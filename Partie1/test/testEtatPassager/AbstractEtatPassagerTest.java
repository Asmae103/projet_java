package testEtatPassager;

import static org.junit.Assert.*;
import org.junit.Test;

import etatPassager.IEtatPassager;

/**
 *  Plan de test pour tous les types de passagers.
 *  Les classes qui héritent de cette classe doivent fournir des méthodes
 * pour créer un passager dehors, assis ou debout.
 */
public abstract class AbstractEtatPassagerTest {


    /**
     *  Doit créer un passager à l'état "dehors".
     * @return un passager dehors
     */
    protected abstract IEtatPassager creerPassagerDehors();
    
    /**
     *  Doit créer un passager à l'état "assis".
     * @return  un passager assis
     */
    protected abstract IEtatPassager creerPassagerAssis();

    /**
     *  Doit créer un passager à l'état "debout".
     * @return  un passager debout
     */
    protected abstract IEtatPassager creerPassagerDebout();

    
    /**
     *   Teste qu'un passager créé dehors est bien extérieur.
     */
    @Test
    public void testInitialEstExterieur() {
        IEtatPassager p = creerPassagerDehors();
        assertTrue(p.estExterieur());
        assertFalse(p.estInterieur());
    }

    /**
     *   Teste qu'un passager créé assis est bien assis et à l'intérieur.
    */
    @Test
    public void testInitialEstAssis() {
        IEtatPassager p = creerPassagerAssis();
        assertTrue(p.estAssis());
        assertTrue(p.estInterieur());
    }

    /**
     * Teste les changements d'état : dehors -> assis, assis -> debout.
     * Vérifie aussi que l'objet d'origine ne change pas.
     */
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