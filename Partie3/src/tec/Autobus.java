package tec;

public class Autobus implements Bus , Transport {
     
	private jaugeNaturel jaugeAssis;
	private jaugeNaturel jaugeDebout;

	/**
	 * Constructeur de l'Autobus.
	 * @param placesAssises nombre de places assises
	 * @param placesDebout nombre de places debout
	 */
	public Autobus(int placesAssises, int placesDebout) {
		// JaugeNaturel(min, max, niveau)
		// min = 0      → niveau minimum autorisé (jamais de passagers négatifs)
		// max = placesAssises  → capacité maximale du bus
		// niveau = 0  → nombre de passagers actuels (bus vide au départ)
		jaugeAssis = new jaugeNaturel(0, placesAssises, 0);
		jaugeDebout = new jaugeNaturel(0, placesDebout, 0);
	}


	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		// vide en Partie 3
	}
    
	// estRouge = plein, donc !estRouge = il reste une place 
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
		if (aPlaceAssise()) {
			jaugeAssis.incrementer();
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if (aPlaceDebout()) {
			jaugeDebout.incrementer();
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if (aPlaceDebout()) {
			jaugeAssis.decrementer();
			jaugeDebout.incrementer();
		}
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if (aPlaceAssise()) {
			jaugeDebout.decrementer();
			jaugeAssis.incrementer();
		}
	}

	@Override
	public void demanderSortie(Passager p) {
		// vide en Partie 3
	}

	@Override
	public String toString() {
		return "[bus assis=" + jaugeAssis + ", debout=" + jaugeDebout + "]";
	}
}