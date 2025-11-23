package tec;

public class PassagerStandard implements Usager , Passager{
	private String nom;
	private int destination;
	private EtatPassager etat;
	
	/**
	 * Constructeur du passager standard avec état initial.
	 * @param nom le nom du passager
	 * @param destination L'arrêt de destination
	 * @param etat l'état initial du passager (assis, debout, dehors)
	 */
	public PassagerStandard(String nom, int destination, EtatPassager etat) {
		// TODO: Implémenter la logique du constructeur
	}

	/**
	 * Constructeur du passager standard (état initial DEHORS).
	 * @param nom le nom du passager
	 * @param destination L'arrêt de destination
	 */
	public PassagerStandard(String nom, int destination) {
		this(nom, destination, new EtatPassager(EtatPassager.Etat.DEHORS));
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
