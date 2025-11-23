package tec;

/**
 * Classe de test pour la version JaugeNaturel.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
public class JaugeNaturelTest extends AbstractJaugeTest {
    
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeNaturel(min, max, val);
    }
}
