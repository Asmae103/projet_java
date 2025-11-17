# Guide Étape par Étape pour Réaliser le Projet dans Eclipse Java

## Prérequis
- Eclipse IDE for Java Developers installé
- JDK (Java Development Kit) installé

## Étape 1 : Création du Projet dans Eclipse

### 1.1 Créer un nouveau projet Java
1. Ouvrir Eclipse
2. Fichier → Nouveau → Projet Java
3. Nom du projet : `Projet_JAVA_Parti4`
4. Cocher "Utiliser les JRE par défaut" ou sélectionner votre JDK
5. Cliquer sur "Terminer"

### 1.2 Configurer le projet
1. Clic droit sur le projet → Propriétés
2. Chemin de compilation Java → Source
3. Vérifier que le dossier source est bien `src`
4. OK

## Étape 2 : Importer les Fichiers Existant

### 2.1 Copier les fichiers sources
1. Ouvrir l'explorateur de fichiers
2. Naviguer vers le dossier du projet Eclipse
3. Copier le contenu du dossier `src` fourni dans le dossier `src` de votre projet Eclipse
4. Rafraîchir le projet dans Eclipse (F5 ou clic droit → Rafraîchir)

### 2.2 Vérifier la structure
Votre projet devrait avoir cette structure :
```
Projet_JAVA_Parti4/
├── src/
│   ├── Simple.java
│   ├── tec/
│   │   ├── Bus.java
│   │   ├── Passager.java
│   │   ├── Transport.java
│   │   ├── Usager.java
│   │   └── UsagerInvalideException.java
```

## Étape 3 : Créer les Classes Manquantes

### 3.1 Créer la classe PassagerStandard
1. Clic droit sur le package `tec` → Nouveau → Classe
2. Nom : `PassagerStandard`
3. Interfaces : `Usager`, `Passager`
4. Modificateurs : `public`
5. Cocher "Générer les commentaires"
6. Cliquer sur "Terminer"

### 3.2 Créer la classe Autobus
1. Clic droit sur le package `tec` → Nouveau → Classe
2. Nom : `Autobus`
3. Interfaces : `Transport`, `Bus`
4. Modificateurs : `public`
5. Cocher "Générer les commentaires"
6. Cliquer sur "Terminer"

## Étape 4 : Implémentation des Classes de Support

### 4.1 Créer la classe EtatPassager
1. Clic droit sur le package `tec` → Nouveau → Classe
2. Nom : `EtatPassager`
3. Modificateurs : (pas de modificateur public, classe privée au package)
4. Cliquer sur "Terminer"

### 4.2 Créer la classe JaugeNaturel
1. Clic droit sur le package `tec` → Nouveau → Classe
2. Nom : `JaugeNaturel`
3. Modificateurs : (pas de modificateur public, classe privée au package)
4. Cliquer sur "Terminer"

## Étape 5 : Implémentation Version Minimale

### 5.1 Implémenter PassagerStandard (version minimale)
```java
package tec;

public class PassagerStandard implements Usager, Passager {
    private String nom;
    private int destination;
    private EtatPassager etat;
    
    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        this.etat = new EtatPassager(); // État initial : dehors
    }
    
    @Override
    public String nom() {
        return nom;
    }
    
    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        // Version minimale : corps vide
    }
    
    @Override
    public boolean estDehors() {
        return false; // Version minimale
    }
    
    @Override
    public boolean estAssis() {
        return false; // Version minimale
    }
    
    @Override
    public boolean estDebout() {
        return false; // Version minimale
    }
    
    @Override
    public void accepterSortie() {
        // Version minimale : corps vide
    }
    
    @Override
    public void accepterPlaceAssise() {
        // Version minimale : corps vide
    }
    
    @Override
    public void accepterPlaceDebout() {
        // Version minimale : corps vide
    }
    
    @Override
    public void nouvelArret(Bus bus, int numeroArret) {
        // Version minimale : corps vide
    }
}
```

### 5.2 Implémenter Autobus (version minimale)
```java
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
        // Version minimale : corps vide
    }
    
    @Override
    public boolean aPlaceAssise() {
        return false; // Version minimale
    }
    
    @Override
    public boolean aPlaceDebout() {
        return false; // Version minimale
    }
    
    @Override
    public void demanderPlaceAssise(Passager p) {
        // Version minimale : corps vide
    }
    
    @Override
    public void demanderPlaceDebout(Passager p) {
        // Version minimale : corps vide
    }
    
    @Override
    public void demanderChangerEnDebout(Passager p) {
        // Version minimale : corps vide
    }
    
    @Override
    public void demanderChangerEnAssis(Passager p) {
        // Version minimale : corps vide
    }
    
    @Override
    public void demanderSortie(Passager p) {
        // Version minimale : corps vide
    }
}
```

## Étape 6 : Implémenter les Classes de Support

### 6.1 Implémenter EtatPassager
```java
package tec;

class EtatPassager {
    private static final int DEHORS = 0;
    private static final int ASSIS  = 1;
    private static final int DEBOUT = 2;
    
    private int etat;
    
    public EtatPassager() {
        this.etat = DEHORS; // État initial
    }
    
    public boolean estAssis() {
        return etat == ASSIS;
    }
    
    public boolean estDebout() {
        return etat == DEBOUT;
    }
    
    public boolean estDehors() {
        return etat == DEHORS;
    }
    
    public void assis() {
        etat = ASSIS;
    }
    
    public void debout() {
        etat = DEBOUT;
    }
    
    public void dehors() {
        etat = DEHORS;
    }
}
```

### 6.2 Implémenter JaugeNaturel
```java
package tec;

class JaugeNaturel {
    private long maximum;
    private long valeur;
    
    public JaugeNaturel(long max, long vigie) {
        this.maximum = max;
        this.valeur = vigie;
    }
    
    public boolean estRouge() {
        return valeur > maximum;
    }
    
    public boolean estVert() {
        return valeur <= maximum;
    }
    
    public boolean estBleu() {
        return valeur < 0;
    }
    
    public void incrementer() {
        valeur++;
    }
    
    public void decrementer() {
        valeur--;
    }
    
    public Long getValeur() {
        return valeur;
    }
    
    public Long getMax() {
        return maximum;
    }
}
```

## Étape 7 : Compiler et Exécuter

### 7.1 Compiler le projet
1. Dans Eclipse, sélectionner le projet
2. Projet → Nettoyer...
3. Cocher "Nettoyer tous les projets"
4. Cliquer sur "Nettoyer"

### 7.2 Corriger les erreurs de compilation
- Vérifier que toutes les classes sont correctement implémentées
- Corriger les erreurs signalées par Eclipse

### 7.3 Exécuter le test
1. Ouvrir la classe `Simple.java`
2. Clic droit dans l'éditeur → Exécuter en tant que → Application Java
3. Observer la sortie dans la console

## Étape 8 : Implémentation Complète

### 8.1 Compléter PassagerStandard
```java
// Remplacer les méthodes vides par l'implémentation complète

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
public boolean estDehors() {
    return etat.estDehors();
}

@Override
public boolean estAssis() {
    return etat.estAssis();
}

@Override
public boolean estDebout() {
    return etat.estDebout();
}

@Override
public void accepterSortie() {
    etat.dehors();
}

@Override
public void accepterPlaceAssise() {
    etat.assis();
}

@Override
public void accepterPlaceDebout() {
    etat.debout();
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
```

### 8.2 Compléter Autobus
```java
// Ajouter ces attributs et compléter les méthodes
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
public boolean aPlaceAssise() {
    return assises.estVert();
}

@Override
public boolean aPlaceDebout() {
    return debouts.estVert();
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
public void demanderChangerEnDebout(Passager p) {
    if (p.estAssis() && aPlaceDebout()) {
        assises.decrementer();
        debouts.incrementer();
        p.accepterPlaceDebout();
    }
}

@Override
public void demanderChangerEnAssis(Passager p) {
    if (p.estDebout() && aPlaceAssise()) {
        debouts.decrementer();
        assises.incrementer();
        p.accepterPlaceAssise();
    }
}

@Override
public void demanderSortie(Passager p) {
    for (int i = 0; i < nbPassagers; i++) {
        if (passagers[i] == p) {
            // Décaler les passagers restants
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
```

## Étape 9 : Tests et Validation

### 9.1 Créer les classes de test
1. Clic droit sur le package `tec` → Nouveau → Classe
2. Nom : `PassagerStandardTest`
3. Cocher "public static void main(String[] args)"
4. Répéter pour `AutobusTest`

### 9.2 Exécuter les tests
1. Exécuter `Simple.java` comme application Java
2. Vérifier que la sortie correspond au résultat attendu :
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

## Étape 10 : Débogage et Correction

### 10.1 Utiliser le débogueur Eclipse
1. Double-clic dans la marge gauche pour mettre un point d'arrêt
2. Clic droit sur la classe → Déboguer en tant que → Application Java
3. Utiliser F6 (pas à pas) et F8 (continuer) pour naviguer

### 10.2 Résoudre les problèmes courants
- **NullPointerException** : Vérifier que tous les objets sont initialisés
- **ArrayIndexOutOfBoundsException** : Vérifier les bornes des tableaux
- **ClassCastException** : Vérifier les casts de type

## Conseils pour Eclipse

### Raccourcis utiles
- `Ctrl + Shift + O` : Organiser les imports
- `Ctrl + Shift + F` : Formater le code
- `Ctrl + Espace` : Assistance de contenu
- `F3` : Aller à la déclaration
- `Ctrl + Shift + T` : Ouvrir un type

### Configuration recommandée
1. Fenêtre → Préférences → Java → Éditeur
2. Cocher "Assistance de contenu automatique"
3. Configurer les modèles de code pour accélérer le développement

Ce guide vous permet de réaliser le projet étape par étape dans Eclipse, de la création du projet à l'implémentation complète et aux tests.