package tec;

/**
 * Implémentation de IJauge qui fonctionne en calculant des distances.
 * Au lieu de stocker une valeur, cette classe stocke la distance par rapport au minimum.
 */
public class JaugeDistance implements IJauge {
    
    // Stocke la distance entre la valeur actuelle et la borne minimale.
    private int distanceMin;
    
    // Stocke la distance totale entre la borne minimale et la borne maximale.
    private final int distanceTotale;

    /**
     * Construit la jauge en calculant les distances initiales.
     * @param min borne minimale
     * @param max borne maximale
     * @param depart valeur de départ
     */
    public JaugeDistance(long min, long max, long depart) {
        this.distanceMin = (int) (depart - min);
        this.distanceTotale = (int) (max - min);
    }

    @Override
    public boolean estRouge() { 
        return distanceMin >= distanceTotale; 
    }
    
    @Override
    public boolean estVert() { 
        return distanceMin > 0 && distanceMin < distanceTotale; 
    }
    
    @Override
    public boolean estBleu() { 
        return distanceMin <= 0; 
    }
    
    @Override
    public void incrementer() { 
        distanceMin++; 
    }
    
    @Override
    public void decrementer() { 
        distanceMin--; 
    }
}
