package testEtatPassager;

import etatPassager.EtatPassagerChaine;
import etatPassager.IEtatPassager;

// Classe "lanceur de test" pour la version EtatPassagerChaine.
// Son seul rôle est de dire à AbstractEtatPassagerTest quelle classe concrète tester.
public class EtatPassagerChaineTest extends AbstractEtatPassagerTest {
    
    // Fournit l'implémentation pour créer un passager "dehors" avec un String.
    @Override
    protected IEtatPassager creerPassagerDehors() {
        return new EtatPassagerChaine("dehors");
    }
    
    // Fournit l'implémentation pour créer un passager "assis" avec un String.
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassagerChaine("assis");
    }
    
    // Fournit l'implémentation pour créer un passager "debout" avec un String.
    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassagerChaine("debout");
    }
}