package testJaugeNaturel;

import jauge.IJauge;
import jauge.JaugeNegatif;

/**
 * Classe de test pour l'implémentation JaugeNegatif.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 **/ 
  public class JaugeNegatifTest extends AbstractJaugeTest {
 
	  /**
	     * Crée une jauge de type JaugeNegatif avec une valeur minimale,
	     * une valeur maximale et une valeur initiale.
	     *
	     * @param min valeur minimale
	     * @param max valeur maximale
	     * @param val valeur initiale
	     * @return une nouvelle instance de JaugeNegatif
	     */
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeNegatif(min, max, val);
    }
}