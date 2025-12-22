package tec;

import org.junit.Test;

public class AutobusTest {
    Autobus a = new Autobus(10, 20);

    /**
     * Vérifie que les méthodes d'état peuvent être appelées
     * les méthodes ont un corps vide ou retournent false par défaut
     */
    @Test
    public void testPlaces() {
        a.aPlaceAssise();
        a.aPlaceDebout();
    }
    //

    /**
     * Vérification d'exécution des méthodes sans exception
     * Ces méthodes ont actuellement un corps vide
     */
    @Test
    public void testDemander() {
        Passager p = new PassagerStandard("Test", 5);
        a.demanderPlaceAssise(p);
        a.demanderPlaceDebout(p);
        a.demanderChangerEnDebout(p);
        a.demanderChangerEnAssis(p);
        a.demanderSortie(p);
    }

    /**
     * Appeler la méthode allerArretSuivant
     * le corps de la méthode est vide donc aucune action
     * @throws UsagerInvalideException 
     */
    @Test
    public void testAllerArretSuivant() throws UsagerInvalideException {
        a.allerArretSuivant();
    }
}
