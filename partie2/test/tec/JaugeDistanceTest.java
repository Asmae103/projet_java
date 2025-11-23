package tec;

/**
 * Classe de test pour la version JaugeDistance.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
public class JaugeDistanceTest extends AbstractJaugeTest {
    
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeDistance(min, max, val);
    }
}
