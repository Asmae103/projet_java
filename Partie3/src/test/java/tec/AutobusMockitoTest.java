package tec;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

/**
 * Tests Mockito de la classe Autobus.
 * Ces tests vérifient uniquement les appels effectués par l'Autobus
 * sur les passagers (interactions), et non l'état global du système.
 */
public class AutobusMockitoTest {

    /**
     * Vérifie que lorsqu'un passager demande une place assise :
     * - l'autobus appelle accepterPlaceAssise() sur le passager
     * - une place assise est consommée
     */
    @Test
    public void testDemanderPlaceAssise_appelleAccepterPlaceAssise() {
        Autobus bus = new Autobus(1, 0);
        Passager p = mock(Passager.class);

        bus.demanderPlaceAssise(p);

        verify(p).accepterPlaceAssise();
        assertFalse(bus.aPlaceAssise());
    }

    /**
     * Vérifie que lorsqu'un passager demande une place debout :
     * - l'autobus appelle accepterPlaceDebout() sur le passager
     * - une place debout est consommée
     */
    @Test
    public void testDemanderPlaceDebout_appelleAccepterPlaceDebout() {
        Autobus bus = new Autobus(0, 1);
        Passager p = mock(Passager.class);

        bus.demanderPlaceDebout(p);

        verify(p).accepterPlaceDebout();
        assertFalse(bus.aPlaceDebout());
    }

    /**
     * Vérifie que lorsqu'un passager sort du bus :
     * - l'autobus appelle accepterSortie() sur le passager
     * - la place assise est libérée
     */
    @Test
    public void testDemanderSortie_appelleAccepterSortie_et_liberePlace() {
        Autobus bus = new Autobus(1, 0);
        Passager p = mock(Passager.class);

        bus.demanderPlaceAssise(p);
        clearInvocations(p); // on ignore l'appel précédent

        bus.demanderSortie(p);

        verify(p).accepterSortie();
        assertTrue(bus.aPlaceAssise());
    }

    /**
     * Vérifie que lors du passage à l'arrêt suivant :
     * - le numéro d'arrêt est incrémenté
     * - chaque passager présent est notifié via nouvelArret(bus, numero)
     */
    @Test
    public void testAllerArretSuivant_notifiePassager() throws UsagerInvalideException {
        Autobus bus = new Autobus(1, 0);
        Passager p = mock(Passager.class);
      
        bus.demanderPlaceAssise(p);
        clearInvocations(p); // on ignore l'appel accepterPlaceAssise()

        bus.allerArretSuivant();

        verify(p).nouvelArret(bus, 1);
    }
}
