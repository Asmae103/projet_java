package testJaugeNaturel;

import static org.junit.Assert.*;
import org.junit.Test;

import jauge.IJauge;

/**
 *  Classe  de test abstrait pour toutes les implémentations de IJauge.
 *  Les classes qui héritent de cette classe doivent fournir une méthode
 * pour créer une jauge concrète à partir de valeurs min, max et val.
 */
public abstract class AbstractJaugeTest {

	/**
     * Crée une jauge avec une valeur minimale, maximale et une valeur initiale.
     * @param min valeur minimale
     * @param max valeur maximale
     * @param val valeur initiale
     * @return une jauge créée avec les paramètres donnés
     */
    protected abstract IJauge creerJauge(long min, long max, long val);

    /**
     *  Teste le cas où la valeur est bien entre les bornes.
     */
    @Test
    public void testDansIntervalle() {
        IJauge j = creerJauge(100, 200, 150);
        assertFalse(j.estBleu());
        assertTrue(j.estVert());
        assertFalse(j.estRouge());
    }

    /**
     *  Teste le cas où la valeur est exactement sur la borne inférieure.
     */
    @Test
    public void testLimiteInferieure() {
        IJauge j = creerJauge(100, 200, 100);
        assertTrue(j.estBleu());
        assertFalse(j.estVert());
        assertFalse(j.estRouge());
    }

    /**
     *  Teste le cas où la valeur est exactement sur la borne supérieure.
     */
    @Test
    public void testLimiteSuperieure() {
        IJauge j = creerJauge(100, 200, 200);
        assertFalse(j.estBleu());
        assertFalse(j.estVert());
        assertTrue(j.estRouge());
    }

    /**
     *  Teste les méthodes incrementer() et decrementer().
     */
    @Test
    public void testDeplacer() {
        IJauge j = creerJauge(10, 100, 12);
        
        // On décrémente jusqu'à la limite.
        j.decrementer(); // niveau = 11
        j.decrementer(); // niveau = 10
        assertTrue(j.estBleu());

        // On incrémente pour revenir dans l'intervalle.
        j.incrementer(); // niveau = 11
        assertTrue(j.estVert());
    }
}