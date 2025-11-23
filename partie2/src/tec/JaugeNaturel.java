package tec;

/**
 * Implémentation standard de IJauge qui utilise des nombres entiers (long).
 * Utilise les fonctionnalités modernes de Java 21.
 */
public class JaugeNaturel implements IJauge {
    
    // La valeur actuelle de la jauge.
    private long niveau;
    
    // Les bornes minimale et maximale (immuables).
    private final long min;
    private final long max;

    /**
     * Construit la jauge avec ses bornes et une valeur de départ.
     * @param min borne minimale
     * @param max borne maximale
     * @param depart valeur initiale
     */
    public JaugeNaturel(long min, long max, long depart) {
        this.min = min;
        this.max = max;
        this.niveau = depart;
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
        niveau++; 
    }
    
    @Override
    public void decrementer() { 
        niveau--; 
    }
}
