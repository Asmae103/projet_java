package testJaugeNaturel;

import jauge.IJauge;
import jauge.jaugeNaturel;

// Classe "lanceur de test" pour la version jaugeNaturel.
// Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
public class JaugeNaturelTest extends AbstractJaugeTest {
    
    // Fournit l'implémentation pour créer une instance de jaugeNaturel.
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new jaugeNaturel(min, max, val);
    }
}