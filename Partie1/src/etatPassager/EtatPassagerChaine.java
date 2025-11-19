package etatPassager;

// Implémentation de IEtatPassager qui utilise des chaînes de caractères (String).
public class EtatPassagerChaine implements IEtatPassager {
    
    // Stocke l'état actuel sous forme de texte. "final" veut dire immuable.
    private final String monEtat;

    // Construit un passager avec un état initial (une chaîne de caractères).
    public EtatPassagerChaine(String etat) {
        this.monEtat = etat;
    }

    // Vérifie si le texte de l'état est "dehors".
    @Override
    public boolean estExterieur() {
        return monEtat.equals("dehors");
    }

    // Vérifie si le texte de l'état est "assis".
    @Override
    public boolean estAssis() {
        return monEtat.equals("assis");
    }

    // Vérifie si le texte de l'état est "debout".
    @Override
    public boolean estDebout() {
        return monEtat.equals("debout");
    }

    // Vérifie si le passager est à l'intérieur.
    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }

    // Crée un nouvel objet passager avec l'état "dehors".
    @Override
    public IEtatPassager changerEnDehors() {
        return new EtatPassagerChaine("dehors");
    }

    // Crée un nouvel objet passager avec l'état "assis".
    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassagerChaine("assis");
    }

    // Crée un nouvel objet passager avec l'état "debout".
    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassagerChaine("debout");
    }

    // Fournit une représentation textuelle de l'objet (ex: "<assis>").
    @Override
    public String toString() {
        return "<" + monEtat + ">";
    }
}