package tec;

import static org.junit.Assert.*;

import org.junit.*;

import tec.IJauge;
import tec.jaugeNaturel;

/**
 * Classe de test pour l'implémentation jaugeNaturel.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */

public class JaugeNaturelTest extends AbstractJaugeTest {
    
	/**
     * Crée une jauge de type jaugeNaturel avec une valeur minimale,
     * maximale et une valeur initiale.
     *
     * @param min valeur minimale
     * @param max valeur maximale
     * @param val valeur initiale
     * @return une jaugeNaturel créée avec les paramètres donnés
     */
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new jaugeNaturel(min, max, val);
    }
    
    @Test
    public void testCreationNonValide ( ) {
		/*
		 * IJauge inverse = creerJauge ( 78 , 13 , 0 ) ;
		 *  IJauge egale = creerJauge ( -45
		 * , -45, -45);
		 */
    	 IJauge inverse = null;
    	    IJauge egale = null;

    	    // Cas min > max
    	    try {
    	        inverse = creerJauge(78, 13, 0);
    	        fail("L'exception n'a pas été levée (min > max)"); //échoue le test si aucune exception n’est levée
    	    } catch (IllegalArgumentException e) {
    	        assertNull(inverse); // vérifie que l’objet n’a pas été créé
    	    }

    	    // Cas min == max
    	    try {
    	        egale = creerJauge(-45, -45, -45);
    	        fail("L'exception n'a pas été levée (min == max)");
    	    } catch (IllegalArgumentException e) {
    	        assertNull(egale);
    	    }
    }
    
	
	/*
	 * @Test(expected = NullPointerException.class) public void
	 * testExceptionControlee ( ) { throw new NullPointerException (" Attention ");
	 * }
	 */
	
    
	  private void testExceptionControlee() throws ClassNotFoundException { 
		  throw new ClassNotFoundException("Attention"); 
	  }
	 
	  
}

