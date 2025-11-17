# Plan de Travail pour Équipe de 3 Personnes - Projet Transports En Commun

## Répartition des Tâches de Codage

### Personne 1 : Développeur Classes de Base et Tests
- **Classes à coder** : EtatPassager, JaugeNaturel, UsagerInvalideException
- **Tests à coder** : EtatPassagerTest, JaugeNaturelTest
- **Intégration** : Simple.java et tests d'intégration

### Personne 2 : Développeur Passager et Comportements
- **Classes à coder** : PassagerStandard
- **Interfaces à implémenter** : Usager, Passager
- **Tests à coder** : PassagerStandardTest

### Personne 3 : Développeur Transport et Gestion
- **Classes à coder** : Autobus
- **Interfaces à implémenter** : Transport, Bus
- **Tests à coder** : AutobusTest

## Phase 1 : Classes de Base (Jour 1)

### Personne 1 : Classes de Support
```java
// À coder : EtatPassager.java
package tec;

class EtatPassager {
    private static final int DEHORS = 0;
    private static final int ASSIS  = 1;
    private static final int DEBOUT = 2;
    private int etat;
    
    public EtatPassager() {
        this.etat = DEHORS;
    }
    
    public boolean estAssis() { return etat == ASSIS; }
    public boolean estDebout() { return etat == DEBOUT; }
    public boolean estDehors() { return etat == DEHORS; }
    public void assis() { etat = ASSIS; }
    public void debout() { etat = DEBOUT; }
    public void dehors() { etat = DEHORS; }
}
```

### Personne 2 : Squelette PassagerStandard
```java
// À coder : PassagerStandard.java (version minimale)
package tec;

public class PassagerStandard implements Usager, Passager {
    private String nom;
    private int destination;
    private EtatPassager etat;
    
    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.etat = new EtatPassager();
    }
    
    @Override
    public String nom() { return nom; }
    
    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public boolean estDehors() { return etat.estDehors(); }
    @Override
    public boolean estAssis() { return etat.estAssis(); }
    @Override
    public boolean estDebout() { return etat.estDebout(); }
    
    @Override
    public void accepterSortie() { etat.dehors(); }
    @Override
    public void accepterPlaceAssise() { etat.assis(); }
    @Override
    public void accepterPlaceDebout() { etat.debout(); }
    
    @Override
    public void nouvelArret(Bus bus, int numeroArret) {
        // TODO : À implémenter phase 2
    }
}
```

### Personne 3 : Squelette Autobus
```java
// À coder : Autobus.java (version minimale)
package tec;

public class Autobus implements Transport, Bus {
    private JaugeNaturel assises;
    private JaugeNaturel debouts;
    
    public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
        this.assises = new JaugeNaturel(nbPlaceAssise, 0);
        this.debouts = new JaugeNaturel(nbPlaceDebout, 0);
    }
    
    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public boolean aPlaceAssise() { return assises.estVert(); }
    @Override
    public boolean aPlaceDebout() { return debouts.estVert(); }
    
    @Override
    public void demanderPlaceAssise(Passager p) {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public void demanderPlaceDebout(Passager p) {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public void demanderChangerEnDebout(Passager p) {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public void demanderChangerEnAssis(Passager p) {
        // TODO : À implémenter phase 2
    }
    
    @Override
    public void demanderSortie(Passager p) {
        // TODO : À implémenter phase 2
    }
}
```

## Phase 2 : Implémentation Complète (Jour 2-3)

### Personne 1 : JaugeNaturel et Tests
```java
// À compléter : JaugeNaturel.java
package tec;

class JaugeNaturel {
    private long maximum;
    private long valeur;
    
    public JaugeNaturel(long max, long vigie) {
        this.maximum = max;
        this.valeur = vigie;
    }
    
    public boolean estRouge() { return valeur > maximum; }
    public boolean estVert() { return valeur <= maximum; }
    public boolean estBleu() { return valeur < 0; }
    
    public void incrementer() { valeur++; }
    public void decrementer() { valeur--; }
    
    public Long getValeur() { return valeur; }
    public Long getMax() { return maximum; }
}

// À coder : JaugeNaturelTest.java
package tec;

public class JaugeNaturelTest {
    public static void main(String[] args) {
        testCreation();
        testIncrementation();
        testDecrementation();
        testLimites();
    }
    
    private static void testCreation() {
        JaugeNaturel jauge = new JaugeNaturel(100, 50);
        assert jauge.getValeur() == 50;
        assert jauge.getMax() == 100;
        System.out.println("Test création : OK");
    }
    
    // ... autres méthodes de test
}
```

### Personne 2 : Logique PassagerStandard
```java
// À compléter dans PassagerStandard.java
@Override
public void monterDans(Transport t) throws UsagerInvalideException {
    Bus b = (Bus) t;
    if (b.aPlaceAssise()) {
        b.demanderPlaceAssise(this);
    } else if (b.aPlaceDebout()) {
        b.demanderPlaceDebout(this);
    }
    // Sinon, le passager reste dehors
}

@Override
public void nouvelArret(Bus bus, int numeroArret) {
    if (numeroArret == destination) {
        bus.demanderSortie(this);
    }
}

@Override
public String toString() {
    return nom + " " + (estAssis() ? "assis" : (estDebout() ? "debout" : "dehors"));
}

// À coder : PassagerStandardTest.java
package tec;

public class PassagerStandardTest {
    public static void main(String[] args) {
        testCreation();
        testEtats();
        testMonterDans();
        testNouvelArret();
    }
    
    private static void testCreation() {
        PassagerStandard p = new PassagerStandard("Test", 5);
        assert p.nom().equals("Test");
        assert p.estDehors();
        System.out.println("Test création passager : OK");
    }
    
    // ... autres méthodes de test
}
```

### Personne 3 : Logique Autobus
```java
// À compléter dans Autobus.java
private Passager[] passagers;
private int nbPassagers;
private int numeroArret;

public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
    this.assises = new JaugeNaturel(nbPlaceAssise, 0);
    this.debouts = new JaugeNaturel(nbPlaceDebout, 0);
    this.passagers = new Passager[nbPlaceAssise + nbPlaceDebout];
    this.nbPassagers = 0;
    this.numeroArret = 1;
}

@Override
public void allerArretSuivant() throws UsagerInvalideException {
    numeroArret++;
    for (int i = 0; i < nbPassagers; i++) {
        passagers[i].nouvelArret(this, numeroArret);
    }
}

@Override
public void demanderPlaceAssise(Passager p) {
    if (aPlaceAssise() && p.estDehors()) {
        passagers[nbPassagers++] = p;
        assises.incrementer();
        p.accepterPlaceAssise();
    }
}

@Override
public void demanderPlaceDebout(Passager p) {
    if (aPlaceDebout() && p.estDehors()) {
        passagers[nbPassagers++] = p;
        debouts.incrementer();
        p.accepterPlaceDebout();
    }
}

@Override
public void demanderSortie(Passager p) {
    for (int i = 0; i < nbPassagers; i++) {
        if (passagers[i] == p) {
            for (int j = i; j < nbPassagers - 1; j++) {
                passagers[j] = passagers[j + 1];
            }
            passagers[--nbPassagers] = null;
            
            if (p.estAssis()) {
                assises.decrementer();
            } else if (p.estDebout()) {
                debouts.decrementer();
            }
            p.accepterSortie();
            break;
        }
    }
}

@Override
public String toString() {
    return "[arret:" + numeroArret + ", assis:" + assises.getValeur() + 
           ", debout:" + debouts.getValeur() + "]";
}

// À coder : AutobusTest.java
package tec;

public class AutobusTest {
    public static void main(String[] args) {
        testCreation();
        testPlaces();
        testGestionPassagers();
        testAllerArretSuivant();
    }
    
    private static void testCreation() {
        Autobus bus = new Autobus(5, 10);
        assert bus.aPlaceAssise();
        assert bus.aPlaceDebout();
        System.out.println("Test création autobus : OK");
    }
    
    // ... autres méthodes de test
}
```

## Phase 3 : Tests d'Intégration (Jour 4)

### Personne 1 : Intégration et Debug
```java
// À vérifier et compléter : Simple.java
import tec.Usager;
import tec.Transport;
import tec.UsagerInvalideException;
import tec.PassagerStandard;
import tec.Autobus;

class Simple {
    static private void deboguerEtat(Transport t, Usager p) {
        System.out.println(p);
        System.out.println(t);
    }

    static public void main(String[] args) throws UsagerInvalideException {
        Transport serenity = new Autobus(1, 2);
        Usager kaylee = new PassagerStandard("Kaylee", 5);

        serenity.allerArretSuivant();
        System.out.println(serenity);

        kaylee.monterDans(serenity);

        Usager jayne = new PassagerStandard("Jayne", 4);
        jayne.monterDans(serenity);

        serenity.allerArretSuivant();
        System.out.println(serenity);
        System.out.println(kaylee);
        System.out.println(jayne);

        Usager inara = new PassagerStandard("Inara", 5);
        inara.monterDans(serenity);

        serenity.allerArretSuivant();
        System.out.println(serenity);
        System.out.println(kaylee);
        System.out.println(jayne);
        System.out.println(inara);

        serenity.allerArretSuivant();
        System.out.println(serenity);
        System.out.println(kaylee);
        System.out.println(jayne);
        System.out.println(inara);

        serenity.allerArretSuivant();
        System.out.println(serenity);
        System.out.println(kaylee);
        System.out.println(jayne);
        System.out.println(inara);
    }
}
```

### Personne 2 : Tests Complémentaires Passager
```java
// À compléter : tests avancés dans PassagerStandardTest.java
private static void testCasLimites() {
    // Test avec destination = 1
    PassagerStandard p1 = new PassagerStandard("Dest1", 1);
    // Test avec destination très grande
    PassagerStandard p2 = new PassagerStandard("Dest100", 100);
    // Test avec nom vide
    PassagerStandard p3 = new PassagerStandard("", 5);
    
    System.out.println("Tests cas limites : OK");
}

private static void testInteractionBus() {
    // Test d'interaction complète avec un autobus
    Autobus bus = new Autobus(2, 2);
    PassagerStandard p = new PassagerStandard("Test", 3);
    
    try {
        p.monterDans(bus);
        assert p.estAssis() || p.estDebout();
        System.out.println("Test interaction bus : OK");
    } catch (UsagerInvalideException e) {
        System.err.println("Erreur : " + e.getMessage());
    }
}
```

### Personne 3 : Tests Complémentaires Autobus
```java
// À compléter : tests avancés dans AutobusTest.java
private static void testCapaciteMaximale() {
    Autobus bus = new Autobus(1, 1);
    PassagerStandard p1 = new PassagerStandard("P1", 5);
    PassagerStandard p2 = new PassagerStandard("P2", 5);
    PassagerStandard p3 = new PassagerStandard("P3", 5);
    
    p1.monterDans(bus);
    p2.monterDans(bus);
    p3.monterDans(bus); // Ne devrait pas monter
    
    // Vérifier que seulement 2 passagers sont dans le bus
    System.out.println("Test capacité maximale : OK");
}

private static void testChangerPlace() {
    Autobus bus = new Autobus(1, 1);
    PassagerStandard p = new PassagerStandard("Test", 5);
    
    p.monterDans(bus);
    // Test changement de place
    if (p.estAssis()) {
        bus.demanderChangerEnDebout(p);
        assert p.estDebout();
    }
    
    System.out.println("Test changement place : OK");
}
```

## Phase 4 : Finalisation (Jour 5)

### Personne 1 : Documentation et Finalisation
```java
// À ajouter : Javadoc complète pour toutes les classes
/**
 * Documentation Javadoc à compléter pour chaque classe et méthode
 * avec @param, @return, @throws
 */
```

### Personne 2 : Optimisation Passager
```java
// À optimiser : PassagerStandard.java
// Ajouter des validations, gérer les cas d'erreur
// Améliorer les performances si nécessaire
```

### Personne 3 : Optimisation Autobus
```java
// À optimiser : Autobus.java
// Ajouter des validations, gérer les cas d'erreur
// Améliorer la gestion des passagers
```

## Planning Quotidien

### Matin (9h-12h)
- **30 min** : Point d'équipe sur l'avancement
- **2h30** : Codage individuel des tâches du jour

### Après-midi (14h-17h)
- **2h** : Codage individuel
- **1h** : Tests et intégration avec les autres

### Fin de journée (17h-17h30)
- **30 min** : Mise à jour du code partagé et planification

## Vérification Quotidienne

### Fin de chaque jour :
- [ ] Code compilé sans erreur
- [ ] Tests unitaires passent
- [ ] Code poussé sur le dépôt partagé
- [ ] Documentation à jour

## Résultat Attendu Final

À la fin du projet, l'exécution de Simple.java doit produire :
```
[arret:1, assis:0, debout:0]
[arret:2, assis:1, debout:1]
Kaylee assis
Jayne debout
[arret:3, assis:1, debout:2]
Kaylee assis
Jayne debout
Inara debout
[arret:4, assis:1, debout:1]
Kaylee assis
Jayne dehors
Inara debout
[arret:5, assis:0, debout:0]
Kaylee dehors
Jayne dehors
Inara dehors
```

Ce plan assure que chaque personne a des tâches de codage concrètes et équilibrées tout au long du projet.