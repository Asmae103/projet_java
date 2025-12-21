package tec;
import static org.junit.Assert.*;



import org.junit.Test;// 

import fauxTest.FauxBusAssis;
import fauxTest.FauxBusDebout;
import fauxTest.FauxBusPlein;
import fauxTest.FauxBusVide;
import tec.PassagerStandard;
import tec.UsagerInvalideException;
public class PassagerStandardTest {
	
	PassagerStandard p = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEHORS));
	
	 /**
     * Teste les états de base d'un passager : assis, debout, dehors.
     */
	@Test 
	public void testEtats() {
		
		
		assertTrue(p.estDehors());
		assertFalse(p.estAssis());
		assertFalse(p.estDebout());
		}
	
    @Test
    public void testConstructeurAvecDestinationSeule() {
        PassagerStandard p = new PassagerStandard(5);
        
        assertEquals("PassagerStandard5", p.nom());
        assertTrue(p.estDehors());
    }
	/**
     * Vérifie qu'un passager instancié assis est bien assis.
     */
	@Test
	public void testInstanciationAssis() { 
		PassagerStandard p1 = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.ASSIS));
		assertFalse("1",p1.estDehors());
		assertTrue("2",p1.estAssis());
		assertFalse("3",p1.estDebout());
	}
	 /**
     * Vérifie qu'un passager instancié debout est bien debout.
     */
	@Test
	public void testInstanciationDebout() { 
		PassagerStandard p1 = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEBOUT));
		assertFalse("4",p1.estDehors());
		assertFalse("5",p1.estAssis());
		assertTrue("6",p1.estDebout());
	}
	 /**
     * Vérifie qu'un passager instancié dehors est bien dehors.
     */
	@Test 
	public void testInstanciationDehors() { 
		PassagerStandard p1 = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEHORS));
		assertTrue("7",p1.estDehors());
		assertFalse("8",p1.estAssis());
		assertFalse("9",p1.estDebout());
	}

    /**
     * Vérifie l'exécution des modificateurs sans exception.
     * Teste accepterPlaceAssise, accepterPlaceDebout et accepterSortie.
     */
	
	@Test 
	public void testAccepter() {
		
		p.accepterPlaceAssise();
		
		//assertFalse("1",p.estAssis());
		assertTrue("Assis1",p.estAssis());
		assertFalse("Debout1",p.estDebout());
		assertFalse("Dehors1",p.estDehors());
		
		//REMETTRE le passager dehors
	    p.accepterSortie();
	    assertTrue("Dehors avant debout", p.estDehors());
		
		p.accepterPlaceDebout();
		
		assertFalse("Assis2",p.estAssis());
		assertTrue("Debout2",p.estDebout());
		//assertFalse("test2",p.estDebout());
		assertFalse("Dehors2",p.estDehors());
		
		p.accepterSortie();

		assertFalse("Assis3",p.estAssis());
		assertFalse("Debout3",p.estDebout());
		assertTrue("Dehors3",p.estDehors());
	}
	
	
	/**
	 * Vérifie que monterDans() demande une place assise quand le bus
	 * en propose une via un FauxBusAssis. Le passager doit devenir assis.
	 */

	@Test
	public void testMonterFauxBusAssis() throws UsagerInvalideException {
		
		FauxBusAssis fba = new FauxBusAssis();
		p.monterDans(fba);
		
		assertTrue("Assis4",p.estAssis());
		assertFalse("Debout4",p.estDebout());
		assertFalse("Dehors4",p.estDehors());
		
		assertEquals(":demanderPlaceAssise:", fba.message);
	}
	
	/**
	 * Vérifie que monterDans() demande une place debout quand seule
	 * une place debout est disponible via un FauxBusDebout. Le passager
	 * doit devenir debout.
	 */
	@Test
	public void testMonterFauxBusDebout() throws UsagerInvalideException {
		
		FauxBusDebout fbd = new FauxBusDebout();
		p.monterDans(fbd);
		
		assertFalse("Assis5",p.estAssis());
		assertTrue("Debout5",p.estDebout());
		assertFalse("Dehors5",p.estDehors());
		
		assertEquals(":demanderPlaceDebout:", fbd.message);
	}
	
	/**
	 * Vérifie que monterDans() ne change pas l'état du passager lorsque
	 * le bus n'a aucune place disponible (FauxBusPlein). Le passager reste dehors.
	 */
	@Test
	public void testMonterFauxBusPlein() throws UsagerInvalideException {
		   FauxBusPlein fbp = new FauxBusPlein();
		    
		    try {
		        p.monterDans(fbp);  // ✅ Lance une exception
		        fail("UsagerInvalideException devait être levée");
		    } catch (UsagerInvalideException e) {
		        // ✅ Exception attendue
		        assertEquals("Aucune place disponible", e.getMessage());
		        assertEquals(p, e.quelUsager);
		        assertEquals(fbp, e.quelTransport);
		    }
		    
		    // Vérifier que le passager est resté dehors
		    assertTrue("Dehors6", p.estDehors());
		    assertFalse("Assis6", p.estAssis());
		    assertFalse("Debout6", p.estDebout());
		    
		    assertEquals("Bus Plein", fbp.message);
		
	}

	 /**
     * Vérifie l'appel de la méthode nouvelArret.
     * Le corps de la méthode est vide dans cette itération, donc aucun changement d'état n'est attendu.
     */
	
	
	@Test 
	public void testNouvelArret() {
		FauxBusVide fbv = new FauxBusVide();
        p.nouvelArret(fbv,4);
		
		assertFalse("Assis7",p.estAssis());
		assertFalse("Debout7",p.estDebout());
		assertTrue("Dehors7",p.estDehors());
		
		assertEquals("Bus Vide", fbv.message);
		
		
	}
	

}
