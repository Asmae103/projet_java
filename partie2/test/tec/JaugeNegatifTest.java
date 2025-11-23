package tec;

/**
 * Classe de test pour la version JaugeNegatif.
 * Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
 */
public class JaugeNegatifTest extends AbstractJaugeTest {
    
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeNegatif(min, max, val);
    }
}
