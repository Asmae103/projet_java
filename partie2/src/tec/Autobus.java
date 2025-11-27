package tec;

public class Autobus implements Bus , Transport {
	
	/**
	 * Constructeur de l'Autobus.
	 * @param placesAssises nombre de places assises
	 * @param placesDebout nombre de places debout
	 */
	public Autobus(int placesAssises, int placesDebout) {
		// TODO: Implémenter la logique du constructeur
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean aPlaceAssise() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aPlaceDebout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderSortie(Passager p) {
		// TODO Auto-generated method stub
		
	}
	

}