package jaugeNaturel;

/**
 * Classe représentant une jauge avec un niveau compris entre un minimum et un maximum.
 */
public class jaugeNaturel {
  private final long min;
  private final long max;
  private long niveau;
  /**
   * Construit une instance en précisant la valeur de départ de la Jauge
   * et l'intervalle de vigie.
   *
   * @param vigieMin valeur minimale de l'intervalle de vigie.
   * @param vigieMax valeur maximale de l'intervalle de vigie.
   * @param depart   valeur initiale de la jauge.
   */
  
  public jaugeNaturel(long vigieMin, long vigieMax, long depart) {
    min = vigieMin;
    max = vigieMax;
    niveau = depart;
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe, il n'y a pas de type de retour.
     */
  }


  /**
   * L'état de la jauge est-il rouge ?
   *
   * @return vrai si niveau supérieur ou égal à vigieMax.
   *
   */
  public boolean estRouge() {
    return (niveau >= max);
  	}
  

  /**
   * L'état de la jauge est-il vert ?
   *
   * @return vrai si niveau appartient à ]vigieMin, vigieMax[.
   *
   */
  public boolean estVert() {
      return (niveau > min && niveau <max);
  }

  /**
   * L'état de la jauge est-il bleu ?
   *
   * @return vrai si niveau inferieur ou égale à vigieMin.
   */
  public boolean estBleu() {
    return (niveau <= min);
  }

  /**
   * Incrémente la valeur du niveau d'une unité.
   * L'état peut devenir supérieur à vigieMax.
   */
  public void incrementer() {
	  niveau += 1;
    
  }

  /**
   * Décrémente la valeur du niveau d'une unité.
   * L'état peut devenir inférieur à la vigieMin.
   */
  public void decrementer() {
	  niveau -=1;
	  
  }


  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une
   * chaîne de caractères correspondant a l'état d'un objet.
   * <p> Un code par défaut est définit dans
   * {@link java.lang.Object#toString() la classe Object}
   * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
   *
   * Pour les chaînes de cararctères, l'opérateur + correspond a la concaténation.
   * Les valeurs numériques sont alors convertit en ascii.
   * Si l'état d'une instance de cette classe est min=-456, max=23,
   */ 
  
     //valeur=-7, la concaténation donne la chaîne  <-7 [-456,23]> .
 
  @Override
  public String toString() {
    return "<" + niveau + " [" + min + "," + max + "]>";
  }
}