 package etatPassager;

// Implémentation de IEtatPassager qui utilise une énumération (enum).
public class EtatPassager implements IEtatPassager {
    
	  /**
     * Énumération représentant les états possibles d'un passager.
     */
    public enum Etat { ASSIS, DEBOUT, DEHORS };
    
    /**
     *  Stocke l'état actuel du passager. "final" veut dire qu'il est immuable.
     */
    private final Etat monEtat;

    /**
     * Construit un passager avec un état initial.
     *
     * @param e l'état initial du passager
     */
    public EtatPassager(Etat e) {
        monEtat = e;
    }

    /**
     *  Vérifie si le passager est dehors.
     *  @return true si le passager est dehors, false sinon
     */
    @Override
    public boolean estExterieur() {
        return monEtat == Etat.DEHORS;
    }

    /**
     *  Vérifie si le passager est assis.
     *  @return true si le passager est assis, false sinon
     */
    @Override
    public boolean estAssis() {
        return monEtat == Etat.ASSIS;
    }

    /**
     *  Vérifie si le passager est debout.
     *  @return true si le passager est debout, false sinon
     */
    @Override
    public boolean estDebout() {
        return monEtat == Etat.DEBOUT;
    }

    /**
     *  Vérifie si le passager est à l'intérieur (assis ou debout).
     *  @return true si le passager est assis ou debout, false sinon
     */
    @Override
    public boolean estInterieur() {
        return estAssis() || estDebout();
    }

    /**
     * Crée un nouvel objet passager à l'état "dehors".
     * @return un nouvel {@code EtatPassager} représentant le passager dehors
     */
    @Override
    public IEtatPassager changerEnDehors() {
        return new EtatPassager(Etat.DEHORS);
    }

    /**
     *  Crée un nouvel objet passager à l'état "assis".
     *  @return un nouvel représentant le passager assis
     */
    @Override
    public IEtatPassager changerEnAssis() {
        return new EtatPassager(Etat.ASSIS);
    }

    /**
     *  Crée un nouvel objet passager à l'état "debout".
     *  @return un nouvel représentant le passager debout
     */
    @Override
    public IEtatPassager changerEnDebout() {
        return new EtatPassager(Etat.DEBOUT);
    }

    /**
     *  Fournit une représentation textuelle de l'objet.
     *   @return une chaîne  où etat est "assis", "debout" ou "dehors"
     */
    @Override
    public String toString() {
        return "<" + monEtat.toString().toLowerCase() + ">";
    }
}