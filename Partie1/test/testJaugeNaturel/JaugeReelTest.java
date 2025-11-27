package testJaugeNaturel;

import jauge.IJauge;
import jauge.JaugeReel;

/**
 *  Classe de test pour l'implémentation JaugeReel.
 *  Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
 
public class JaugeReelTest extends AbstractJaugeTest {
    
	  /**
     * Crée une jauge de type JaugeReel avec une valeur minimale,
     * une valeur maximale et une valeur initiale.
     *
     * @param min valeur minimale
     * @param max valeur maximale
     * @param val valeur initiale
     * @return une instance de JaugeReel
     */
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeReel(min, max, val);
    }
}