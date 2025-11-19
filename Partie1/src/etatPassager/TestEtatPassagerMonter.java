package etatPassager;

// Classe "lanceur de test" pour la version EtatPassagerMonter.
public class TestEtatPassagerMonter extends AbstractEtatPassagerTest {
    
    // Fournit l'implémentation pour créer un passager "assis".
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassagerMonter(EtatPassager.Etat.ASSIS);
    }

    // Fournit l'implémentation pour créer un passager "debout".
    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassagerMonter(EtatPassager.Etat.DEBOUT);
    }

    // Cette méthode est requise par le plan de test abstrait.
    @Override
    protected IEtatPassager creerPassagerDehors() {
        // Cette ligne va volontairement provoquer une erreur,
        // car EtatPassagerMonter ne peut pas être à l'état DEHORS.
        return new EtatPassagerMonter(EtatPassager.Etat.DEHORS);
    }
}




/* Le test testInitialEstExterieur (défini dans AbstractEtatPassagerTest) va appeler
creerPassagerDehors(). Cette méthode va essayer de créer un new EtatPassagerMonter
avec l'état DEHORS, ce qui va déclencher l'erreur IllegalArgumentException que nous avons
programmée dans le constructeur*/