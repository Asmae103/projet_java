package tec;

/**
 * Implémentation de IEtatPassager qui utilise des chaînes de caractères (String).
 */
public class EtatPassagerChaine implements IEtatPassager {
    
    // Stocke l'état actuel sous forme de texte. "final" veut dire immuable.
    private final String monEtat;

    /**
     * Construit un passager avec un état initial (une chaîne de caractères).
     * @param etat l'état initial ("assis", "debout", ou "dehors")
     */
    public EtatPassagerChaine(String etat) {
        this.monEtat = etat;
    }

    @Override
    public boolean estExterieur() {
        return monEtat.equals("dehors");
    }

    @Override
    public boolean estAssis() {
        return monEtat.equals("assis");
    }

    @Override
    public boolean estDebout() {
        return monEtat.equals("debout");
    }

    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }

    @Override
    public IEtatPassager changerEnDehors() {
        return new EtatPassagerChaine("dehors");
    }

    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassagerChaine("assis");
    }

    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassagerChaine("debout");
    }

    @Override
    public String toString() {
        return "<%s>".formatted(monEtat);
    }
}
