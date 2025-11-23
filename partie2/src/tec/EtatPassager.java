package tec;

// Implémentation de IEtatPassager qui utilise une énumération (enum).
public class EtatPassager implements IEtatPassager {
    
    // Définit les trois états possibles pour un passager.
    public enum Etat { ASSIS, DEBOUT, DEHORS };
    
    // Stocke l'état actuel du passager. "final" veut dire qu'il est immuable.
    private final Etat monEtat;

    // Construit un passager avec un état initial.
    public EtatPassager(Etat e) {
        monEtat = e;
    }

    // Vérifie si le passager est dehors.
    @Override
     public boolean estExterieur() {
        return monEtat == Etat.DEHORS;
    }

    // Vérifie si le passager est assis.
    @Override
    public boolean estAssis() {
        return monEtat == Etat.ASSIS;
    }

    // Vérifie si le passager est debout.
    @Override
    public boolean estDebout() {
        return monEtat == Etat.DEBOUT;
    }

    // Vérifie si le passager est à l'intérieur (assis ou debout).
    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }

    // Crée un nouvel objet passager à l'état "dehors".
    @Override
    public IEtatPassager changerEnDehors() {
        return new EtatPassager(Etat.DEHORS);
    }

    // Crée un nouvel objet passager à l'état "assis".
    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassager(Etat.ASSIS);
    }

    // Crée un nouvel objet passager à l'état "debout".
    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassager(Etat.DEBOUT);
    }

    // Fournit une représentation textuelle de l'objet.
    @Override
    public String toString() {
        return "<" + monEtat.toString().toLowerCase() + ">";
    }
}
