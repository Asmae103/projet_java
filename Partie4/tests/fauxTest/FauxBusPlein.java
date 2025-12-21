package fauxTest;

import tec.Bus;
import tec.Passager;
import tec.Transport;

public  class FauxBusPlein implements Bus, Transport {
	  public String message = "Bus Plein";

	  public boolean aPlaceAssise() {
	    return false;
	  }

	  public boolean aPlaceDebout() {
	    return false;
	  }

	  public void demanderPlaceAssise(Passager p) {
	    message = ":demanderPlaceAssise:";
	  }

	  public void demanderPlaceDebout(Passager p) {
	    message = ":demanderPlaceDebout:";
	  }

	  public void demanderChangerEnDebout(Passager p) {
	    message = ":demanderChangerEnDebout:";
	  }
	  
	  public void demanderChangerEnAssis(Passager p) {
	    message = ":demanderChangerEnAssis:";
	  }

	  public void demanderSortie(Passager p) {
	    message = ":demanderSortie:";    
	    p.accepterSortie();
	  }

	  public void allerArretSuivant() { //throws UsagerInvalideException {
	  }
	  
	  public int dernierArret() {  
	        return 10;
	    }

}

