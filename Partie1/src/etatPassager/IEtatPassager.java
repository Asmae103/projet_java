package etatPassager;

/**
 * Définit le "contrat" pour toutes les classes qui représentent l'état d'un passager.
 * Toute classe qui implémente cette interface doit fournir ces méthodes.
 */
public interface IEtatPassager {
    
    // --- Méthodes pour vérifier l'état actuel ---

    /**
     * @return vrai si le passager est à l'extérieur.
     */
    boolean estExterieur();

    /**
     * @return vrai si le passager est assis.
     */
    boolean estAssis();

    /**
     * @return vrai si le passager est debout.
     */
    boolean estDebout();

    /**
     * @return vrai si le passager est à l'intérieur (assis ou debout).
     */
    boolean estInterieur();
    
    // --- Méthodes pour changer d'état (en créant un nouvel objet) ---

    /**
     * @return une nouvelle instance de passager à l'état "dehors".
     */
    IEtatPassager changerEnDehors();

    /**
     * @return une nouvelle instance de passager à l'état "assis".
     */
    IEtatPassager changerEnAssis();

    /**
     * @return une nouvelle instance de passager à l'état "debout".
     */
    IEtatPassager changerEnDebout();
}