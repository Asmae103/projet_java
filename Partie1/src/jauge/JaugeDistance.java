package jauge;

/**
 *  Implémentation de IJauge qui fonctionne en calculant des distances.
 */
public class JaugeDistance implements IJauge {
    
    /**
     *  Stocke la distance entre la valeur actuelle et la borne minimale.
     */
    private int distanceMin;
    
    /**
     *  Stocke la distance totale entre la borne minimale et la borne maximale.
     */
    private final int distanceTotale;

    /**
     *  Construit la jauge en calculant les distances initiales.
     * @param min
     * @param max
     * @param depart
     */
    public JaugeDistance(long min, long max, long depart) {
        this.distanceMin = (int) (depart - min);
        this.distanceTotale = (int) (max - min);
    }

    /**
     *  Vrai si la distance depuis le min est >= à la distance totale.
     */
    @Override
    public boolean estRouge() { return distanceMin >= distanceTotale; }
    
    /**
     *  Vrai si la distance depuis le min est entre 0 et la distance totale.
     */
    @Override
    public boolean estVert() { return distanceMin > 0 && distanceMin < distanceTotale; }
    
    /**
     *  Vrai si la distance depuis le min est <= 0.
     */
    @Override
    public boolean estBleu() { return distanceMin <= 0; }
    
    /**
     *  Augmenter la valeur revient à augmenter la distance depuis le min.
     */
    @Override
    public void incrementer() { distanceMin++; }
    
    /**
     * Diminuer la valeur revient à diminuer la distance depuis le min.
     */
    @Override
    public void decrementer() { distanceMin--; }
}