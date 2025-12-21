package tec;

/**
 * Fabrique pour créer les objets du système de transport.
 * Cette classe permet de cacher les implémentations concrètes.
 */
public class TransportFactory {
    
    // Constructeur privé pour empêcher l'instanciation
    private TransportFactory() {
        throw new AssertionError("Cette classe ne doit pas être instanciée");
    }
    
    /**
     * Crée un nouvel usager/passager.
     * @param nom le nom de l'usager
     * @param destination le numéro de l'arrêt de destination
     * @return un nouvel usager
     */
    public static Usager creerPassager(String nom, int destination) {
        return new PassagerStandard(nom, destination);
    }
    
    /**
     * Crée un nouveau bus.
     * @param nbPlacesAssises le nombre de places assises
     * @param nbPlacesDebout le nombre de places debout
     * @return un nouveau bus
     */
    public static Transport creerAutobus(int nbPlacesAssises, int nbPlacesDebout) {
        return new Autobus(nbPlacesAssises, nbPlacesDebout);
    }
}