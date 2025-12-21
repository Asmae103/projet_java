package tec;

import static org.junit.Assert.*;

import org.junit.*;

import fauxTest.FauxBusAssis;
import fauxTest.FauxBusPlein;
import tec.Bus;
import tec.PassagerStandard;
import tec.UsagerInvalideException;

/**
 * Classe de tests unitaires pour vérifier la gestion des exceptions
 * dans la classe PassagerStandard.
 * 
 * Ces tests vérifient que les exceptions appropriées sont levées
 * lorsque des paramètres invalides sont utilisés ou lorsque
 * des actions interdites sont effectuées par le passager.
 */
public class PassagerStandartExceptionTest {

    /**
     * Vérifie qu'une IllegalArgumentException est levée
     * lorsque le nom du passager est null.
     */
    @Test 
    public void testNomNull() {
        try {
            PassagerStandard p = new PassagerStandard(null, 5);
            fail("IllegalArgumentException attendue");	
        } catch (IllegalArgumentException e) {
            assertEquals("Le nom ne peut pas etre null", e.getMessage());		
        }
    }

    /**
     * Vérifie qu'une IllegalArgumentException est levée
     * lorsque la destination est négative.
     */
    @Test 
    public void testDestinationIvalide() {
        try {
            PassagerStandard p = new PassagerStandard("Alix", -5);
            fail("IllegalArgumentException devait etre levée");
        } catch (IllegalArgumentException e) {
            assertEquals("La destination ne peut pas etre négative", e.getMessage());			
        }
    }

    /**
     * Vérifie qu'une IllegalArgumentException est levée
     * lorsque l'état du passager est null.
     */
    @Test
    public void testEtatNull() {
        try {
            PassagerStandard p = new PassagerStandard("Alix", 5, null);
            fail("IllegalArgumentException devait etre levée");
        } catch (IllegalArgumentException e) {
            assertEquals("L'état ne peut pas etre null", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une IllegalStateException est levée
     * lorsque le passager est déjà dehors et demande à sortir.
     */
    @Test
    public void testAccepterPlaceAssise_DejaDehors() {
        PassagerStandard passager =
            new PassagerStandard("Alix", 5, new EtatPassager(EtatPassager.Etat.DEHORS));
        try {
            passager.accepterSortie();
            fail("IllegalStateException devait etre levée");
        } catch (IllegalStateException e) {
            assertEquals("Le passager est déja dehors", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une IllegalStateException est levée
     * lorsque le passager déjà assis demande une place assise.
     */
    @Test
    public void testAccepterPlaceAssise_DejaAssis() {
        PassagerStandard passager = new PassagerStandard("Alix", 5);

        passager.accepterPlaceAssise();
        assertTrue(passager.estAssis());

        try {
            passager.accepterPlaceAssise();
            fail("IllegalStateException devait etre levée");
        } catch (IllegalStateException e) {
            assertEquals("Le passager n'est pas dehors", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une IllegalStateException est levée
     * lorsque le passager déjà debout demande une place debout.
     */
    @Test
    public void testAccepterPlaceAssise_DejaDebout() {
        PassagerStandard passager = new PassagerStandard("Alix", 5);

        passager.accepterPlaceDebout();
        assertTrue(passager.estDebout());

        try {
            passager.accepterPlaceDebout();
            fail("IllegalStateException devait etre levée");
        } catch (IllegalStateException e) {
            assertEquals("Le passager n'est pas dehors", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une IllegalArgumentException est levée
     * lorsque le bus fourni est null.
     */
    @Test 
    public void testNouvellArret_BusNull() {
        PassagerStandard passager = new PassagerStandard("Alix", 5);
        try {
            passager.nouvelArret(null, 2);
            fail("IllegalArgumentException devait etre levée");	
        } catch (IllegalArgumentException e) {
            assertEquals("Le bus ne peut pas etre null", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une IllegalArgumentException est levée
     * lorsque le numéro d'arrêt est négatif.
     */
    @Test 
    public void testNouvellArret_NumeroArretNegatif() {
        Bus bus = new FauxBusAssis();
        PassagerStandard passager = new PassagerStandard("Alix", 5);
        try {
            passager.nouvelArret(bus, -2);
            fail("IllegalArgumentException devait etre levée");	
        } catch (IllegalArgumentException e) {
            assertEquals("Le numéro d'arret ne peut pas etre négatif", e.getMessage());
        }
    }

    /**
     * Vérifie qu'une UsagerInvalideException est levée
     * lorsqu'aucune place n'est disponible dans le bus.
     */
    @Test 
    public void testMonterDans_PasPlaceDisponible() throws UsagerInvalideException {
        FauxBusPlein bus = new FauxBusPlein();
        PassagerStandard p = new PassagerStandard("Olivia", 3);

        try {
            p.monterDans(bus);
            fail("UsagerInvalideException devait etre levée");
        } catch (UsagerInvalideException e) {
            assertEquals("Aucune place disponible", e.getMessage());
            assertEquals(p, e.quelUsager);
            assertEquals(bus, e.quelTransport);
        }
    }
}
