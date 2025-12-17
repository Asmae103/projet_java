package tec;

/**
 * Version minimale d'Autobus pour compilation.
 * Implémente Transport et Bus.
 */
public class Autobus implements Transport, Bus {

    private jaugeNaturel jaugeAssis;
    private jaugeNaturel jaugeDebout;
    private Passager[] passagers;
    private int numeroArret;

    public Autobus(int nbAssis, int nbDebout) {
        this.jaugeAssis = new jaugeNaturel(0, nbAssis, 0);
        this.jaugeDebout = new jaugeNaturel(0, nbDebout, 0);
        this.passagers = new Passager[nbAssis + nbDebout];
        this.numeroArret = 1;
    }

    private void ajouterPassager(Passager p) {
        for (int i = 0; i < passagers.length; i++) {
            if (passagers[i] == null) {
                passagers[i] = p;
                break;
            }
        }
    }

    private void retirerPassager(Passager p) {
        for (int i = 0; i < passagers.length; i++) {
            if (passagers[i] == p) {
                passagers[i] = null;
                break;
            }
        }
    }

    @Override
    public boolean aPlaceAssise() {
        return !jaugeAssis.estRouge();
    }

    @Override
    public boolean aPlaceDebout() {
        return !jaugeDebout.estRouge();
    }

    @Override
    public void demanderPlaceAssise(Passager p) {
        if (p.estDehors() && aPlaceAssise()) {
            p.accepterPlaceAssise();
            jaugeAssis.incrementer();
            ajouterPassager(p);
        }
    }

    @Override
    public void demanderPlaceDebout(Passager p) {
        if (p.estDehors() && aPlaceDebout()) {
            p.accepterPlaceDebout();
            jaugeDebout.incrementer();
            ajouterPassager(p);
        }
    }

    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (p.estAssis() && aPlaceDebout()) {
            p.accepterPlaceDebout();
            jaugeAssis.decrementer();
            jaugeDebout.incrementer();
        }
    }

    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (p.estDebout() && aPlaceAssise()) {
            p.accepterPlaceAssise();
            jaugeDebout.decrementer();
            jaugeAssis.incrementer();
        }
    }

    @Override
    public void demanderSortie(Passager p) {
        if (p.estAssis()) {
            jaugeAssis.decrementer();
        } else if (p.estDebout()) {
            jaugeDebout.decrementer();
        }
        p.accepterSortie();
        retirerPassager(p);
    }

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        numeroArret++;
        for (Passager p : passagers) {
            if (p != null) {
                p.nouvelArret(this, numeroArret);
            }
        }
    }

    @Override
    public String toString() {
        return "[arret:" + numeroArret + ", assis:" + jaugeAssis.getNiveau() + ", debout:" + jaugeDebout.getNiveau() + "]";
    }
}