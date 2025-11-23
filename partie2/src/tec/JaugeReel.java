package tec;

/**
 * Implémentation de IJauge qui utilise des nombres à virgule (float).
 * Elle divise toutes les valeurs par 1000 pour travailler avec des décimales.
 */
public class JaugeReel implements IJauge {
    
    // Stocke la valeur actuelle sous forme de nombre à virgule.
    private float niveau;
    
    // Stocke les bornes min et max sous forme de nombres à virgule.
    private final float min;
    private final float max;

    /**
     * Construit la jauge en divisant les paramètres par 1000.
     * @param min borne minimale (sera divisée par 1000)
     * @param max borne maximale (sera divisée par 1000)
     * @param depart valeur de départ (sera divisée par 1000)
     */
    public JaugeReel(long min, long max, long depart) {
        this.min = (float) min / 1000;
        this.max = (float) max / 1000;
        this.niveau = (float) depart / 1000;
    }

    @Override
    public boolean estRouge() { 
        return niveau >= max; 
    }
    
    @Override
    public boolean estVert() { 
        return niveau > min && niveau < max; 
    }
    
    @Override
    public boolean estBleu() { 
        return niveau <= min; 
    }
    
    @Override
    public void incrementer() { 
        niveau += 0.001f; 
    }
    
    @Override
    public void decrementer() { 
        niveau -= 0.001f; 
    }
}
