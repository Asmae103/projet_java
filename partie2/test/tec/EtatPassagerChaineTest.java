package tec;

/**
 * Classe de test pour la version EtatPassagerChaine.
 * Son seul rôle est de dire à AbstractEtatPassagerTest quelle classe concrète tester.
 */
public class EtatPassagerChaineTest extends AbstractEtatPassagerTest {
    
    @Override
    protected IEtatPassager creerPassagerDehors() {
        return new EtatPassagerChaine("dehors");
    }
    
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassagerChaine("assis");
    }
    
    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassagerChaine("debout");
    }
}
