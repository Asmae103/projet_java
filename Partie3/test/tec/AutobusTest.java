package tec;

import static org.junit.Assert.*;

import org.junit.Test;// 


/**
 * Classe de test pour Autobus.
 */
public class AutobusTest {

    /**
     * Teste la création d'un autobus.
     */
    @Test
    public void testCreationAutobus() {
        Autobus bus = new Autobus(2, 3);

        assertTrue(bus.aPlaceAssise());
        assertTrue(bus.aPlaceDebout());
        assertEquals("[arret:1, assis:0, debout:0]", bus.toString());
    }

    /**
     * Teste la demande de place assise.
     */
    @Test
    public void testDemanderPlaceAssise() {
        Autobus bus = new Autobus(1, 1);
        PassagerStandard passager = new PassagerStandard("Test", 2);

        bus.demanderPlaceAssise(passager);

        assertTrue(passager.estAssis());
        assertEquals("[arret:1, assis:1, debout:0]", bus.toString());
    }

    /**
     * Teste la demande de place debout.
     */
    @Test
    public void testDemanderPlaceDebout() {
        Autobus bus = new Autobus(1, 1);
        PassagerStandard passager = new PassagerStandard("Test", 2);

        bus.demanderPlaceDebout(passager);

        assertTrue(passager.estDebout());
        assertEquals("[arret:1, assis:0, debout:1]", bus.toString());
    }

    /**
     * Teste la demande de sortie.
     */
    @Test
    public void testDemanderSortie() {
        Autobus bus = new Autobus(1, 1);
        PassagerStandard passager = new PassagerStandard("Test", 2);

        bus.demanderPlaceAssise(passager);
        assertTrue(passager.estAssis());

        bus.demanderSortie(passager);
        assertTrue(passager.estDehors());
        assertEquals("[arret:1, assis:0, debout:0]", bus.toString());
    }

    /**
     * Teste aller à l'arrêt suivant.
     */
    @Test
    public void testAllerArretSuivant() throws UsagerInvalideException {
        Autobus bus = new Autobus(1, 1);

        bus.allerArretSuivant();
        assertEquals("[arret:2, assis:0, debout:0]", bus.toString());
    }

    /**
     * Teste qu'un bus plein n'accepte pas de nouveaux passagers.
     */
    @Test
    public void testBusPlein() {
        Autobus bus = new Autobus(0, 0); // Aucun place

        assertFalse(bus.aPlaceAssise());
        assertFalse(bus.aPlaceDebout());
    }

    /**
     * Teste le changement de place.
     */
    @Test
    public void testChangementPlace() {
        Autobus bus = new Autobus(1, 1);
        PassagerStandard passager = new PassagerStandard("Test", 2);

        bus.demanderPlaceAssise(passager);
        assertTrue(passager.estAssis());

        bus.demanderChangerEnDebout(passager);
        assertTrue(passager.estDebout());
        assertEquals("[arret:1, assis:0, debout:1]", bus.toString());
    }
}