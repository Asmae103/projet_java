package tec;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe de test pour la version EtatPassagerMonter.
 * Cette classe teste le comportement spécial où un passager ne peut pas être à l'extérieur.
 */
public class TestEtatPassagerMonter extends AbstractEtatPassagerTest {
    
    @Override
    protected IEtatPassager creerPassagerAssis() {
        return new EtatPassagerMonter(EtatPassager.Etat.ASSIS);
    }

    @Override
    protected IEtatPassager creerPassagerDebout() {
        return new EtatPassagerMonter(EtatPassager.Etat.DEBOUT);
    }

    /**
     * Cette méthode est requise par le plan de test abstrait.
     * Elle va volontairement provoquer une erreur car EtatPassagerMonter
     * ne peut pas être à l'état DEHORS.
     */
    @Override
    protected IEtatPassager creerPassagerDehors() {
        return new EtatPassagerMonter(EtatPassager.Etat.DEHORS);
    }
    
    /**
     * Redéfinit le test pour vérifier que créer un passager "dehors" lance bien une exception.
     */
    @Test(expected = IllegalArgumentException.class)
    @Override
    public void testInitialEstExterieur() {
        // Cette ligne doit lancer IllegalArgumentException
        creerPassagerDehors();
    }
    
    /**
     * Redéfinit le test de changements d'états car EtatPassagerMonter ne peut pas sortir.
     * Teste uniquement les transitions internes (assis <-> debout).
     */
    @Test
    @Override
    public void testChangementsEtats() {
        IEtatPassager pAssis = creerPassagerAssis();
        IEtatPassager pDebout = creerPassagerDebout();

        // Teste la transition assis -> debout
        IEtatPassager pNouveau = pAssis.changerEnDebout();
        assertTrue("Le nouveau passager devrait être debout", pNouveau.estDebout());
        assertTrue("Le nouveau passager devrait être à l'intérieur", pNouveau.estInterieur());

        // Teste la transition debout -> assis
        pNouveau = pDebout.changerEnAssis();
        assertTrue("Le nouveau passager devrait être assis", pNouveau.estAssis());
        assertTrue("Le nouveau passager devrait être à l'intérieur", pNouveau.estInterieur());
        
        // Vérifie que l'objet original n'a pas changé (immutabilité)
        assertTrue("L'objet original devrait rester assis", pAssis.estAssis());
        assertTrue("L'objet original devrait rester debout", pDebout.estDebout());
    }
}
