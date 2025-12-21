package tec;

import static org.junit.Assert.*;
import org.junit.*;

import tec.Autobus;
import tec.UsagerInvalideException;

/**
 * Classe de tests unitaires permettant de vérifier la gestion
 * des exceptions dans la classe Autobus.
 * 
 * Ces tests vérifient que des exceptions de type
 * UsagerInvalideException sont levées lorsque des paramètres
 * invalides sont utilisés.
 * 
 * 
 */
public class AutobusExceptionTest {
	
	 /**
     * Vérifie que le constructeur de Autobus lance une
     * UsagerInvalideException lorsque le nombre de places assises
     * est négatif.
     */
    @Test
    public void testConstructeurNbAssisNegatif() {
        try {
            Autobus bus = new Autobus(-1, 10);
            fail("UsagerInvalideException attendue");
        } catch (UsagerInvalideException e) {
            assertEquals("Le nombre de places assises ne peut pas être négatif: -1", e.getMessage());
        }
    }
  
    /**
     * Vérifie que le constructeur de Autobus lance une
     * UsagerInvalideException lorsque le nombre de places debout
     * est négatif.
     */
    @Test
    public void testConstructeurNbDeboutNegatif() {
        try {
            Autobus bus = new Autobus(10, -1);
            fail("UsagerInvalideException attendue");
        } catch (UsagerInvalideException e) {
            assertEquals("Le nombre de places debout ne peut pas être négatif: -1", e.getMessage());
        }
    } 
    
  
	
    /**
     * Vérifie que la méthode demanderPlaceAssise lance une
     * UsagerInvalideException lorsque le passager est null.
     */
	
    @Test
    public void testDemanderPlaceAssise_PassagerNull() {
        try {
            Autobus bus = new Autobus(10, 10);
            bus.demanderPlaceAssise(null);
            fail("UsagerInvalideException attendue");
        } catch (UsagerInvalideException e) {
            assertEquals("Passager null", e.getMessage());
        }
    }
    
    /**
     * Vérifie que la méthode demanderPlaceDebout lance une
     * UsagerInvalideException lorsque le passager est null.
     */
    
    @Test
    public void testDemanderPlaceDebout_PassagerNull() {
        try {
            Autobus bus = new Autobus(10, 10);
            bus.demanderPlaceDebout(null);
            fail("UsagerInvalideException attendue");
        } catch (UsagerInvalideException e) {
            assertEquals("Passager null", e.getMessage());
        }
    }
    
    /**
     * Vérifie que la méthode demanderSortie lance une
     * UsagerInvalideException lorsque le passager est null.
     */
  
    @Test
    public void testDemanderSortie_PassagerNull() {
        try {
            Autobus bus = new Autobus(10, 10);
            bus.demanderSortie(null);
            fail("UsagerInvalideException attendue");
        } catch (UsagerInvalideException e) {
            assertEquals("Passager null", e.getMessage());
        }
    }
    
    /**
     * Vérifie que la méthode allerArretSuivant fonctionne correctement
     * et qu’aucune exception n’est levée.
     */
    @Test
    public void testAllerArretSuivant() {
        try {
            Autobus bus = new Autobus(10, 10);
            bus.allerArretSuivant();
            assertEquals("[arret:2, assis:0, debout:0]", bus.toString());
        } catch (UsagerInvalideException e) {
            fail("Aucune exception ne devrait être lancée");
        }
    }

}
