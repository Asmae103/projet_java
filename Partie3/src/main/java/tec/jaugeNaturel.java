package tec;

/**
 *  Implémentation standard de IJauge qui utilise des nombres entiers (long).
 */
public class jaugeNaturel implements IJauge {
    
    // La valeur actuelle de la jauge.
    private long niveau;
    
    // Les bornes minimale et maximale (immuables).
    private final long min;
    private final long max;

    // Construit la jauge avec ses bornes et une valeur de départ.
    /**
     * 
     * @param min : minimum pour la valeur  de la jauge
     * @param max : maximum
     * @param depart : depart
     */
    public jaugeNaturel(long min, long max, long depart) {
        this.min = min;
        this.max = max;
        this.niveau = depart;
    }

    /**
     *  Vrai si la valeur est supérieure ou égale à la borne max.
     */
    @Override
    public boolean estRouge() { return niveau >= max; }
    
    /**
     *  Vrai si la valeur est strictement entre les bornes min et max.
     */
    @Override
    public boolean estVert() { return niveau > min && niveau < max; }
    
    /**
     *  Vrai si la valeur est inférieure ou égale à la borne min.
     */
    @Override
    public boolean estBleu() { return niveau <= min; }
    
    /**
     *  Augmente le niveau de 1.
     */
    @Override
    public void incrementer() { niveau++; }
    
    /**
     * Diminue le niveau de 1.
     */
    @Override
    public void decrementer() { niveau--; }
    
    /**
     * Retourne la valeur courante de la jauge.
     *
     * @return niveau courant
     */
    public long getNiveau() {
        return niveau;
    }
    
    /**
     * Représentation textuelle de la jauge au format du sujet :
     * "<niveau [min,max]>".
     */
    @Override
    public String toString() {
        return "<" + niveau + " [" + min + "," + max + "]>";
    }
}