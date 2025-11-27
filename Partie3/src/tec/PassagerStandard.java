package tec;

public class PassagerStandard implements Usager , Passager{
    private String nom;
    private int destination;
    private EtatPassager etat; // l'état du passager

    /**
     * Constructeur du passager standard.
     * Le passager est initialement dehors.
     * 
     * @param nom         le nom du passager
     * @param destination l'arrêt de destination
     */
    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.etat = new EtatPassager(EtatPassager.Etat.DEHORS); // état initial : dehors
    }
    
    /**
     * Constructeur principal (pour les tests) : on peut choisir l'état initial
     */
    public PassagerStandard(String nom, int destination, EtatPassager etat) {
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
		
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
		 Bus bus = (Bus) t;

		  if(bus.aPlaceAssise()){ 
			  bus.demanderPlaceAssise(this); 
		  }else if (bus.aPlaceDebout()) { 
			  bus.demanderPlaceDebout(this);
		  }
		  
	}



	@Override
	public String toString() {
		return nom + etat;
	}
		



	

}
