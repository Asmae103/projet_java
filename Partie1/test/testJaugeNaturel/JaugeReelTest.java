package testJaugeNaturel;

import jauge.IJauge;
import jauge.JaugeReel;

// Classe "lanceur de test" pour la version JaugeReel.
// Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
public class JaugeReelTest extends AbstractJaugeTest {
    
    // Fournit l'implémentation pour créer une instance de JaugeReel.
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeReel(min, max, val);
    }
}