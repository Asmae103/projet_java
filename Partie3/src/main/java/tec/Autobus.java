package tec;

public class Autobus implements Bus, Transport {

    private jaugeNaturel jaugeAssis;
    private jaugeNaturel jaugeDebout;

    // Tableaux de stockage des passagers
    // Une case = une place, null = place libre
    private Passager[] assis;
    private Passager[] debout;

    // Numéro de l'arrêt courant (commence à 0)
    private int numeroArret;

    /**
     * Constructeur de l'Autobus.
     *
     * @param placesAssises nombre de places assises (capacité)
     * @param placesDebout  nombre de places debout (capacité)
     */
    public Autobus(int placesAssises, int placesDebout) {
        // JaugeNaturel(min, max, depart)
        // min = 0 : pas de nombre négatif de passagers
        // max = capacité : nombre maximal de passagers
        // depart = 0 : bus vide au départ
        jaugeAssis = new jaugeNaturel(0, placesAssises, 0);
        jaugeDebout = new jaugeNaturel(0, placesDebout, 0);

        // Stockage des passagers
        assis = new Passager[placesAssises];
        debout = new Passager[placesDebout];

        // Arrêt initial
        numeroArret = 0;
    }

    /**
     * Simule le passage à l'arrêt suivant :
     * - on incrémente le numéro d'arrêt
     * - on notifie chaque passager présent (assis et debout)
     */
    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        numeroArret++;

        for (int i = 0; i < assis.length; i++) {
            if (assis[i] != null) {
                assis[i].nouvelArret(this, numeroArret);
            }
        }

        for (int i = 0; i < debout.length; i++) {
            if (debout[i] != null) {
                debout[i].nouvelArret(this, numeroArret);
            }
        }
    }

    /**
     * @return true s'il reste au moins une place assise.
     *         (Une jauge "rouge" signifie que la capacité max est atteinte.)
     */
    @Override
    public boolean aPlaceAssise() {
        return !jaugeAssis.estRouge();
    }

    /**
     * @return true s'il reste au moins une place debout.
     */
    @Override
    public boolean aPlaceDebout() {
        return !jaugeDebout.estRouge();
    }

    /**
     * Place un passager assis si une place existe :
     * - on le stocke dans le tableau assis[]
     * - on incrémente la jauge
     * - on demande au passager d'accepter la place assise
     */
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (!aPlaceAssise()) return;

        for (int i = 0; i < assis.length; i++) {
            if (assis[i] == null) {
                assis[i] = p;
                jaugeAssis.incrementer();
                p.accepterPlaceAssise();
                return;
            }
        }
    }

    /**
     * Place un passager debout si une place existe :
     * - on le stocke dans le tableau debout[]
     * - on incrémente la jauge
     * - on demande au passager d'accepter la place debout
     */
    @Override
    public void demanderPlaceDebout(Passager p) {
        if (!aPlaceDebout()) return;

        for (int i = 0; i < debout.length; i++) {
            if (debout[i] == null) {
                debout[i] = p;
                jaugeDebout.incrementer();
                p.accepterPlaceDebout();
                return;
            }
        }
    }

    /**
     * Déplace un passager assis vers une place debout (si possible) :
     * - on le retire de assis[]
     * - on l'ajoute dans debout[]
     * - on met à jour les jauges
     * - on prévient le passager du changement d'état
     */
    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (!aPlaceDebout()) return;

        for (int i = 0; i < assis.length; i++) {
            if (assis[i] == p) {
                for (int j = 0; j < debout.length; j++) {
                    if (debout[j] == null) {
                        assis[i] = null;
                        debout[j] = p;

                        jaugeAssis.decrementer();
                        jaugeDebout.incrementer();

                        p.accepterPlaceDebout();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Déplace un passager debout vers une place assise (si possible).
     */
    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (!aPlaceAssise()) return;

        for (int i = 0; i < debout.length; i++) {
            if (debout[i] == p) {
                for (int j = 0; j < assis.length; j++) {
                    if (assis[j] == null) {
                        debout[i] = null;
                        assis[j] = p;

                        jaugeDebout.decrementer();
                        jaugeAssis.incrementer();

                        p.accepterPlaceAssise();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Fait sortir un passager du bus (assis ou debout) :
     * - on le retire du tableau
     * - on décrémente la jauge correspondante
     * - on prévient le passager (accepterSortie)
     */
    @Override
    public void demanderSortie(Passager p) {
        for (int i = 0; i < assis.length; i++) {
            if (assis[i] == p) {
                assis[i] = null;
                jaugeAssis.decrementer();
                p.accepterSortie();
                return;
            }
        }

        for (int i = 0; i < debout.length; i++) {
            if (debout[i] == p) {
                debout[i] = null;
                jaugeDebout.decrementer();
                p.accepterSortie();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "[arret=" + numeroArret + ", assis=" + jaugeAssis + ", debout=" + jaugeDebout + "]";
    }
}
