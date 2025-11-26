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
	

	public PassagerStandard(String nom, int destination, EtatPassager etat) {
		super();
		this.nom = nom;
		this.destination = destination;
		this.etat = etat;
	}



	@Override
	public boolean estDehors() {
		// TODO Auto-generated method stub
		return etat.estExterieur();
	}

	@Override
	public boolean estAssis() {
		// TODO Auto-generated method stub
		return etat.estAssis();
	}

	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return etat.estDebout();
	}

	@Override
	public void accepterSortie() {
		// TODO Auto-generated method stub
		etat = (EtatPassager) etat.changerEnDehors();
	
		
	}

	@Override
	public void accepterPlaceAssise() {
		// TODO Auto-generated method stub
		etat = (EtatPassager) etat.changerEnAssis();
	}

	@Override
	public void accepterPlaceDebout() {
		// TODO Auto-generated method stub
		etat =(EtatPassager) etat.changerEnDebout();
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		// TODO Auto-generated method stub
		/*
		 * if(numeroArret == destination) { bus.demanderSortie(this); }
		 */
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		/*
		 * if(!etat.estExterieur()) { throw new
		 * UsagerInvalideException("Le passger n'est pas dehors");
		 * 
		 * } Bus bus = (Bus) t;
		 * 
		 * // Stratégie Standard : demander d’abord une place assise if
		 * (bus.aPlaceAssise()) { bus.demanderPlaceAssise(this); } // Sinon essayer une
		 * place debout else if (bus.aPlaceDebout()) { bus.demanderPlaceDebout(this); }
		 * //Sinon le bus est plein else { throw new
		 * UsagerInvalideException("Bus complet, impossible de monter.");
		 * 
		 * }
		 * 
		 */
		  }
		


	@Override
	public String toString() {
		return "PassagerStandard [nom=" + nom + ", destination=" + destination + ", etat=" + etat + ", estDehors()="
				+ estDehors() + ", estAssis()=" + estAssis() + ", estDebout()=" + estDebout() + ", nom()=" + nom()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
