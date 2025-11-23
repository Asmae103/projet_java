package tec;

/**
 * Classe de test pour la version JaugeReel.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
public class JaugeReelTest extends AbstractJaugeTest {
    
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeReel(min, max, val);
    }
}
