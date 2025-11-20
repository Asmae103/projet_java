package tec;

import org.junit.Test;

public class PassagerStandardTest {
	PassagerStandard p = new PassagerStandard("Tom", 6,  new EtatPassager(EtatPassager.Etat.DEHORS));
	
	/**
	 * Verifie que les methodes d'etat peuvent etre appeler 
	 * les methodes ont un corps vide ou retourne un false par default
	 */
	@Test 
	public void testEtats() {
		
		
		p.estDehors();
		p.estAssis();
		p.estDebout();
		}
	/**
	 * 	Verification d'execution des metodes sans esception
	 * Ces methodes ont actuellemnt un corps vide
	 */
	
	@Test 
	public void testAccepter() {
		 
		p.accepterPlaceAssise();
		p.accepterPlaceDebout();
		p.accepterSortie();
	}

	/**
	 * Appeler les methodes 
	 * utiliser un Autobus et un numero d'arret 
	 * le corps de la methodes et vides donc aucun action
	 */
	@Test 
	public void testNouvelArret() {
		
		Bus bus= new Autobus();// 
		p.nouvelArret(bus,7);
	}
	
	/**
	 * Appeler les methodes 
	 * utiliser un Autobus  
	 * le corps de les methodes et vides donc aucun action
	 */
	@Test
	public void testMonter() throws UsagerInvalideException {
		//tester l'appel de la methode
		Transport t =new Autobus();
		p.monterDans(t);
		p.nom();
	}
}
