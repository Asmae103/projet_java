package jauge;

// Implémentation de IJauge qui utilise des nombres à virgule (float).
// Elle divise toutes les valeurs par 1000.
public class JaugeReel implements IJauge {
    
    // Stocke la valeur actuelle sous forme de nombre à virgule.
    private float niveau;
    
    // Stocke les bornes min et max sous forme de nombres à virgule.
    private final float min;
    private final float max;

    // Construit la jauge en divisant les paramètres par 1000.
    public JaugeReel(long min, long max, long depart) {
        this.min = (float) min / 1000;
        this.max = (float) max / 1000;
        this.niveau = (float) depart / 1000;
    }

    // Vrai si le niveau est supérieur ou égal à la borne max.
    @Override
    public boolean estRouge() { return niveau >= max; }
    
    // Vrai si le niveau est entre les bornes min et max.
    @Override
    public boolean estVert() { return niveau > min && niveau < max; }
    
    // Vrai si le niveau est inférieur ou égal à la borne min.
    @Override
    public boolean estBleu() { return niveau <= min; }
    
    // Augmente le niveau de 1 (en interne, +0.001).
    @Override
    public void incrementer() { niveau += 0.001f; }
    
    // Diminue le niveau de 1 (en interne, -0.001).
    @Override
    public void decrementer() { niveau -= 0.001f; }
}