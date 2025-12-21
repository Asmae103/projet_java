package tec;

import tec.*;

/**
 * Classe de test permettant de vérifier le fonctionnement général
 * du système de transport.
 * 
 * Cette classe illustre l'utilisation des interfaces Transport et Usager
 * ainsi que de la factory TransportFactory pour créer les objets.
 * 
 * Le client manipule uniquement des interfaces et ne dépend pas
 * des classes concrètes.
 */
public class TestTransport {

    /**
     * Méthode principale du programme.
     * 
     * Elle crée un transport et des usagers à l'aide de la factory,
     * fait monter les usagers dans le bus et simule le passage
     * de plusieurs arrêts.
     * 
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        // Créer via la factory (seul moyen)
        Transport bus = TransportFactory.creerAutobus(30, 20);
        Usager usager1 = TransportFactory.creerPassager("Dupont", 3);
        Usager usager2 = TransportFactory.creerPassager("Martin", 5);

        // Le client ne connaît que les interfaces

        try {
            usager1.monterDans(bus);
            usager2.monterDans(bus);

            System.out.println("Arrêt 1");
            bus.allerArretSuivant();

            System.out.println("Arrêt 2");
            bus.allerArretSuivant();

        } catch (UsagerInvalideException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
