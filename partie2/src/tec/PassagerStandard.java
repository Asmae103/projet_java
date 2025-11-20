package tec;

public class PassagerStandard implements Usager , Passager{
	private String nom;
	private int destination;
	private EtatPassager etat;
	
	/**
	 * Constructeur du passager standard.
     * 
     * 
	 * @param nom le nom de paassager
	 * @param destination L'arret 
	 * @param etat l'etat initial du passager (assie, debout, dehors)
	 */
	 // Constructeur avec paramètres mais corps vide
	public PassagerStandard(String nom, int destination, EtatPassager etat) {
		
	}

	
	
	@Override
	public boolean estDehors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estAssis() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void accepterSortie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceAssise() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceDebout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}
	

}
