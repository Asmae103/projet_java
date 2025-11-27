package jauge;

/**
 *  Implémentation de IJauge qui stocke les valeurs avec un signe inversé.
 */
public class JaugeNegatif implements IJauge {
    
    /**
     * Stocke la valeur actuelle (en négatif).
     */
    private long niveau;

    /**
     * Stocke les bornes min et max (en négatif).
     */
    private final long min;
    private final long max;

    /**
     *  Construit la jauge en inversant le signe des paramètres.
     * @param min
     * @param max
     * @param depart
     */
    public JaugeNegatif(long min, long max, long depart) {
        this.min = -min;
        this.max = -max;
        this.niveau = -depart;
    }

    /**
     *  Vrai si le niveau est plus petit ou égal à max (logique inversée).
     */
    @Override
    public boolean estRouge() { return niveau <= max; }
    
    /**
     *  Vrai si le niveau est entre max et min (logique inversée).
     */
    @Override
    public boolean estVert() { return niveau < min && niveau > max; }
    
    /**
     * Vrai si le niveau est plus grand ou égal à min (logique inversée).
     */
    @Override
    public boolean estBleu() { return niveau >= min; }
    
    /**
     *  Augmenter la valeur revient à décrémenter le nombre négatif.
     */
    @Override
    public void incrementer() { niveau--; }
    
    /**
     * Diminuer la valeur revient à incrémenter le nombre négatif.
     */
    @Override
    public void decrementer() { niveau++; }
}