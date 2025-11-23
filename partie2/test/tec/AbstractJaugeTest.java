package tec;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Plan de test abstrait pour toutes les implémentations de IJauge.
 * Utilise le pattern Template Method pour tester toutes les versions de jauges.
 */
public abstract class AbstractJaugeTest {

    /**
     * Méthode abstraite à remplir par les classes filles pour fournir une jauge concrète.
     * @param min borne minimale de la jauge
     * @param max borne maximale de la jauge
     * @param val valeur initiale de la jauge
     * @return une nouvelle instance de jauge
     */
    protected abstract IJauge creerJauge(long min, long max, long val);

    /**
     * Teste le cas où la valeur est bien entre les bornes.
     */
    @Test
    public void testDansIntervalle() {
        IJauge j = creerJauge(100, 200, 150);
        assertFalse("La jauge ne devrait pas être bleue", j.estBleu());
        assertTrue("La jauge devrait être verte", j.estVert());
        assertFalse("La jauge ne devrait pas être rouge", j.estRouge());
    }

    /**
     * Teste le cas où la valeur est exactement sur la borne inférieure.
     */
    @Test
    public void testLimiteInferieure() {
        IJauge j = creerJauge(100, 200, 100);
        assertTrue("La jauge devrait être bleue à la limite inférieure", j.estBleu());
        assertFalse("La jauge ne devrait pas être verte", j.estVert());
        assertFalse("La jauge ne devrait pas être rouge", j.estRouge());
    }

    /**
     * Teste le cas où la valeur est exactement sur la borne supérieure.
     */
    @Test
    public void testLimiteSuperieure() {
        IJauge j = creerJauge(100, 200, 200);
        assertFalse("La jauge ne devrait pas être bleue", j.estBleu());
        assertFalse("La jauge ne devrait pas être verte", j.estVert());
        assertTrue("La jauge devrait être rouge à la limite supérieure", j.estRouge());
    }

    /**
     * Teste les méthodes incrementer() et decrementer().
     */
    @Test
    public void testDeplacer() {
        IJauge j = creerJauge(10, 100, 12);
        
        // On décrémente jusqu'à la limite.
        j.decrementer(); // niveau = 11
        j.decrementer(); // niveau = 10
        assertTrue("La jauge devrait être bleue après décrémentation", j.estBleu());

        // On incrémente pour revenir dans l'intervalle.
        j.incrementer(); // niveau = 11
        assertTrue("La jauge devrait être verte après incrémentation", j.estVert());
    }
}
