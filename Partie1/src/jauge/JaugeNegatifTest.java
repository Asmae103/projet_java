package jauge;

// Classe "lanceur de test" pour la version JaugeNegatif.
// Son seul rôle est de dire à AbstractJaugeTest quelle classe concrète tester.
public class JaugeNegatifTest extends AbstractJaugeTest {
    
    // Fournit l'implémentation pour créer une instance de JaugeNegatif.
    @Override
    protected IJauge creerJauge(long min, long max, long val) {
        return new JaugeNegatif(min, max, val);
    }
}