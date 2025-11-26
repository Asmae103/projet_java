package testJaugeNaturel;

import static org.junit.Assert.*;
import org.junit.Test;

import jauge.IJauge;

// Plan de test abstrait pour toutes les implémentations de IJauge.
public abstract class AbstractJaugeTest {

    // Méthode à remplir par les classes filles pour fournir une jauge concrète.
    protected abstract IJauge creerJauge(long min, long max, long val);

    // Teste le cas où la valeur est bien entre les bornes.
    @Test
    public void testDansIntervalle() {
        IJauge j = creerJauge(100, 200, 150);
        assertFalse(j.estBleu());
        assertTrue(j.estVert());
        assertFalse(j.estRouge());
    }

    // Teste le cas où la valeur est exactement sur la borne inférieure.
    @Test
    public void testLimiteInferieure() {
        IJauge j = creerJauge(100, 200, 100);
        assertTrue(j.estBleu());
        assertFalse(j.estVert());
        assertFalse(j.estRouge());
    }

    // Teste le cas où la valeur est exactement sur la borne supérieure.
    @Test
    public void testLimiteSuperieure() {
        IJauge j = creerJauge(100, 200, 200);
        assertFalse(j.estBleu());
        assertFalse(j.estVert());
        assertTrue(j.estRouge());
    }

    // Teste les méthodes incrementer() et decrementer().
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