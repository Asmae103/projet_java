package tec;

/**
 * Définit le "contrat" pour toutes les classes qui représentent une jauge.
 * Toute classe qui implémente cette interface doit obligatoirement fournir ces méthodes.
 */
public interface IJauge {
    
    // --- Méthodes pour vérifier la couleur/l'état de la jauge ---

    /**
     * @return vrai si la jauge est dans la zone rouge (valeur >= max).
     */
    boolean estRouge();

    /**
     * @return vrai si la jauge est dans la zone verte (valeur > min et < max).
     */
    boolean estVert();

    /**
     * @return vrai si la jauge est dans la zone bleue (valeur <= min).
     */
    boolean estBleu();

    // --- Méthodes pour modifier la valeur de la jauge ---

    /**
     * Augmente la valeur de la jauge d'une unité.
     */
    void incrementer();

    /**
     * Diminue la valeur de la jauge d'une unité.
     */
    void decrementer();
}
