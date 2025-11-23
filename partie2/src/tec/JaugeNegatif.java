package tec;

/**
 * Implémentation de IJauge qui stocke les valeurs avec un signe inversé.
 * Cette classe inverse la logique des zones de couleur.
 */
public class JaugeNegatif implements IJauge {
    
    // Stocke la valeur actuelle (en négatif).
    private long niveau;

    // Stocke les bornes min et max (en négatif).
    private final long min;
    private final long max;

    /**
     * Construit la jauge en inversant le signe des paramètres.
     * @param min borne minimale (sera inversée en interne)
     * @param max borne maximale (sera inversée en interne)
     * @param depart valeur de départ (sera inversée en interne)
     */
    public JaugeNegatif(long min, long max, long depart) {
        this.min = -min;
        this.max = -max;
        this.niveau = -depart;
    }

    @Override
    public boolean estRouge() { 
        return niveau <= max; 
    }
    
    @Override
    public boolean estVert() { 
        return niveau < min && niveau > max; 
    }
    
    @Override
    public boolean estBleu() { 
        return niveau >= min; 
    }
    
    @Override
    public void incrementer() { 
        niveau--; // Augmenter revient à décrémenter le nombre négatif
    }
    
    @Override
    public void decrementer() { 
        niveau++; // Diminuer revient à incrémenter le nombre négatif
    }
}
