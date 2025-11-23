package tec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe EtatPassager.
 * Vérifie le comportement de tous les états et transitions possibles.
 */
public class EtatPassagerTest {

    /**
     * Teste la création d'un passager à l'état assis.
     */
    @Test
    public void testCreerPassagerAssis() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.ASSIS);
        
        assertTrue(passager.estAssis());
        assertFalse(passager.estDebout());
        assertFalse(passager.estExterieur());
        assertTrue(passager.estInterieur());
        assertEquals("<assis>", passager.toString());
    }

    /**
     * Teste la création d'un passager à l'état debout.
     */
    @Test
    public void testCreerPassagerDebout() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.DEBOUT);
        
        assertFalse(passager.estAssis());
        assertTrue(passager.estDebout());
        assertFalse(passager.estExterieur());
        assertTrue(passager.estInterieur());
        assertEquals("<debout>", passager.toString());
    }

    /**
     * Teste la création d'un passager à l'état dehors.
     */
    @Test
    public void testCreerPassagerDehors() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.DEHORS);
        
        assertFalse(passager.estAssis());
        assertFalse(passager.estDebout());
        assertTrue(passager.estExterieur());
        assertFalse(passager.estInterieur());
        assertEquals("<dehors>", passager.toString());
    }

    /**
     * Teste les transitions depuis l'état dehors.
     */
    @Test
    public void testTransitionsDepuisDehors() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.DEHORS);
        
        // Transition vers assis
        EtatPassager passagerAssis = passager.changerEnAssis();
        assertTrue(passagerAssis.estAssis());
        assertFalse(passagerAssis.estDebout());
        assertFalse(passagerAssis.estExterieur());
        
        // Transition vers debout
        EtatPassager passagerDebout = passager.changerEnDebout();
        assertFalse(passagerDebout.estAssis());
        assertTrue(passagerDebout.estDebout());
        assertFalse(passagerDebout.estExterieur());
        
        // L'état original ne doit pas avoir changé (immuabilité)
        assertTrue(passager.estExterieur());
    }

    /**
     * Teste les transitions depuis l'état assis.
     */
    @Test
    public void testTransitionsDepuisAssis() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.ASSIS);
        
        // Transition vers debout
        EtatPassager passagerDebout = passager.changerEnDebout();
        assertFalse(passagerDebout.estAssis());
        assertTrue(passagerDebout.estDebout());
        assertFalse(passagerDebout.estExterieur());
        
        // Transition vers dehors
        EtatPassager passagerDehors = passager.changerEnDehors();
        assertFalse(passagerDehors.estAssis());
        assertFalse(passagerDehors.estDebout());
        assertTrue(passagerDehors.estExterieur());
        
        // L'état original ne doit pas avoir changé (immuabilité)
        assertTrue(passager.estAssis());
    }

    /**
     * Teste les transitions depuis l'état debout.
     */
    @Test
    public void testTransitionsDepuisDebout() {
        EtatPassager passager = new EtatPassager(EtatPassager.Etat.DEBOUT);
        
        // Transition vers assis
        EtatPassager passagerAssis = passager.changerEnAssis();
        assertTrue(passagerAssis.estAssis());
        assertFalse(passagerAssis.estDebout());
        assertFalse(passagerAssis.estExterieur());
        
        // Transition vers dehors
        EtatPassager passagerDehors = passager.changerEnDehors();
        assertFalse(passagerDehors.estAssis());
        assertFalse(passagerDehors.estDebout());
        assertTrue(passagerDehors.estExterieur());
        
        // L'état original ne doit pas avoir changé (immuabilité)
        assertTrue(passager.estDebout());
    }

    /**
     * Teste l'impossibilité d'avoir plusieurs états simultanément.
     */
    @Test
    public void testEtatsMutuellementExclusifs() {
        EtatPassager passagerAssis = new EtatPassager(EtatPassager.Etat.ASSIS);
        EtatPassager passagerDebout = new EtatPassager(EtatPassager.Etat.DEBOUT);
        EtatPassager passagerDehors = new EtatPassager(EtatPassager.Etat.DEHORS);
        
        // Un passager assis ne peut être ni debout ni dehors
        assertTrue(passagerAssis.estAssis());
        assertFalse(passagerAssis.estDebout());
        assertFalse(passagerAssis.estExterieur());
        
        // Un passager debout ne peut être ni assis ni dehors
        assertFalse(passagerDebout.estAssis());
        assertTrue(passagerDebout.estDebout());
        assertFalse(passagerDebout.estExterieur());
        
        // Un passager dehors ne peut être ni assis ni debout
        assertFalse(passagerDehors.estAssis());
        assertFalse(passagerDehors.estDebout());
        assertTrue(passagerDehors.estExterieur());
    }

    /**
     * Teste la cohérence de la méthode estInterieur().
     */
    @Test
    public void testEstInterieur() {
        EtatPassager passagerAssis = new EtatPassager(EtatPassager.Etat.ASSIS);
        EtatPassager passagerDebout = new EtatPassager(EtatPassager.Etat.DEBOUT);
        EtatPassager passagerDehors = new EtatPassager(EtatPassager.Etat.DEHORS);
        
        // Les passagers assis et debout sont à l'intérieur
        assertTrue(passagerAssis.estInterieur());
        assertTrue(passagerDebout.estInterieur());
        
        // Le passager dehors n'est pas à l'intérieur
        assertFalse(passagerDehors.estInterieur());
    }
}