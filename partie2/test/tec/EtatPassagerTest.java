package tec;

/**
 * Classe de test pour la version EtatPassager avec Enum.
 * Son seul rôle est de dire à AbstractEtatPassagerTest quelle classe concrète tester.
 */
public class EtatPassagerTest extends AbstractEtatPassagerTest {
    
    @Override
    protected IEtatPassager creerPassagerDehors() {
        return new EtatPassager(EtatPassager.Etat.DEHORS);
    }
    
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassager(EtatPassager.Etat.ASSIS);
    }
    
    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassager(EtatPassager.Etat.DEBOUT);
    }
}
