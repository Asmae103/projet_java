package testJaugeNaturel;

import jauge.IJauge;
import jauge.jaugeNaturel;

/**
 * Classe de test pour l'implémentation jaugeNaturel.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */

public class JaugeNaturelTest extends AbstractJaugeTest {
    
	/**
     * Crée une jauge de type jaugeNaturel avec une valeur minimale,
     * maximale et une valeur initiale.
     *
     * @param min valeur minimale
     * @param max valeur maximale
     * @param val valeur initiale
     * @return une jaugeNaturel créée avec les paramètres donnés
     */
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new jaugeNaturel(min, max, val);
    }
}