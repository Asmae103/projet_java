package testEtatPassager;

import static org.junit.Assert.*;
import org.junit.Test;

import etatPassager.IEtatPassager;

// Plan de test pour tous les types de passagers.
public abstract class AbstractEtatPassagerTest {

    // Méthodes à remplir par les classes filles 

    // Doit créer un passager à l'état "dehors".
    protected abstract IEtatPassager creerPassagerDehors();
    
    // Doit créer un passager à l'état "assis".
    protected abstract IEtatPassager creerPassagerAssis();

    // Doit créer un passager à l'état "debout".
    protected abstract IEtatPassager creerPassagerDebout();

    
    // Tests 

    // Vérifie l'état initial d'un passager "dehors".
    @Test
    public void testInitialEstExterieur() {
        IEtatPassager p = creerPassagerDehors();
        assertTrue(p.estExterieur());
        assertFalse(p.estInterieur());
    }

    // Vérifie l'état initial d'un passager "assis".
    @Test
    public void testInitialEstAssis() {
        IEtatPassager p = creerPassagerAssis();
        assertTrue(p.estAssis());
        assertTrue(p.estInterieur());
    }

    // Vérifie les changements d'état.
    @Test
    public void testChangementsEtats() {
        IEtatPassager pDehors = creerPassagerDehors();
        IEtatPassager pAssis = creerPassagerAssis();

        // Teste la transition dehors -> assis.
        IEtatPassager pNouveau = pDehors.changerEnAssis();
        assertTrue(pNouveau.estAssis());

        // Teste la transition assis -> debout.
        pNouveau = pAssis.changerEnDebout();
        assertTrue(pNouveau.estDebout());
        
        // Vérifie que l'objet original n'a pas changé.
        assertTrue(pDehors.estExterieur());
    }
}