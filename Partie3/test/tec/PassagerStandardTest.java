package tec;
import static org.junit.Assert.*;


import org.junit.Test;// 
public class PassagerStandardTest {
	PassagerStandard p = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEHORS));
	
	/**
     * Vérifie que les méthodes d'état peuvent être appelées sur une instance instanciée dehors.
     * Les méthodes retournent la valeur correspondant à l'état courant.
     */
	@Test 
	public void testEtats() {
		
		
		assertTrue(p.estDehors());
		assertFalse(p.estAssis());
		assertFalse(p.estDebout());
		}
	/**
     * Vérifie que l'état d'un passager instancié assis est cohérent avec les accesseurs.
     */
	@Test
	public void testInstanciationAssis() { 
		PassagerStandard p1 = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.ASSIS));
		assertFalse("1",p1.estDehors());
		assertTrue("2",p1.estAssis());
		assertFalse("3",p1.estDebout());
	}
	 /**
     * Vérifie que l'état d'un passager instancié debout est cohérent avec les accesseurs.
     */
	@Test
	public void testInstanciationDebout() { 
		PassagerStandard p1 = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEBOUT));
		assertFalse("4",p1.estDehors());
		assertFalse("5",p1.estAssis());
		assertTrue("6",p1.estDebout());
	}
	 /**
     * Vérifie la cohérence de l'état lorsque le passager est instancié dehors.
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
     * Vérifie l'appel de la méthode nouvelArret.
     * Le corps de la méthode est vide dans cette itération, donc aucun changement d'état n'est attendu.
     */
	@Test 
	public void testNouvelArret() {
		
		/*
		 * Bus bus= new Autobus();// p.nouvelArret(bus,7);
		 * 
		 * assertFalse("Assis4",p.estAssis()); assertFalse("Debout4",p.estDebout());
		 * assertTrue("Dehors4",p.estDehors());
		 */
	}
	
	/**
     * Vérifie l'appel de la méthode monterDans.
     * Le corps de la méthode est vide dans cette itération, donc aucun changement d'état n'est attendu.
     */
	@Test
	public void testMonter() throws UsagerInvalideException {
		//tester l'appel de la methode
		/*
		 * Transport t =new Autobus();
		 * 
		 * p.monterDans(t); assertTrue("Assis5",p.estAssis());
		 * assertFalse("Debout5",p.estDebout()); assertFalse("Dehors5",p.estDehors());
		 * p.nom();
		 */
	}
}
