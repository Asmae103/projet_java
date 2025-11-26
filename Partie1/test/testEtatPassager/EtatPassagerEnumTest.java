package testEtatPassager;

import etatPassager.EtatPassager;
import etatPassager.IEtatPassager;
import etatPassager.EtatPassager.Etat;

// Classe "lanceur de test" pour la version EtatPassager avec Enum.
// Son seul rôle est de dire à AbstractEtatPassagerTest quelle classe concrète tester.
public class EtatPassagerEnumTest extends AbstractEtatPassagerTest {
    
    // Fournit l'implémentation pour créer un passager "dehors" avec un Enum.
    @Override
    protected IEtatPassager creerPassagerDehors() {
        return new EtatPassager(EtatPassager.Etat.DEHORS);
    }
    
    // Fournit l'implémentation pour créer un passager "assis" avec un Enum.
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassager(EtatPassager.Etat.ASSIS);
    }
    
    // Fournit l'implémentation pour créer un passager "debout" avec un Enum.
    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassager(EtatPassager.Etat.DEBOUT);
    }
}