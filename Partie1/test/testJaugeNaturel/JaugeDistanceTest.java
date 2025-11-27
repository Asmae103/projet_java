package testJaugeNaturel;

import jauge.IJauge;
import jauge.JaugeDistance;

/**
 *  Classe de test pour la jauge de type JaugeDistance.
 *  Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
 
public class JaugeDistanceTest extends AbstractJaugeTest {
    
	/**
     * Crée une jauge JaugeDistance avec une valeur minimale, maximale
     * et une valeur initiale.
     * 
     * @param min valeur minimale
     * @param max valeur maximale
     * @param val valeur initiale
     * @return une nouvelle jauge JaugeDistance
     */
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeDistance(min, max, val);
    }
}