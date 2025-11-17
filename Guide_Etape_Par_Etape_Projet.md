# Guide Étape par Étape du Projet de Transports En Commun

## Introduction

Ce document explique étape par étape le projet de simulation de transports en commun. L'objectif est de développer un cadriciel (framework) qui permet de simuler la montée et la sortie des usagers d'un transport sur une ligne d'arrêts.

## 1. Compréhension du Projet

### 1.1 Objectif Principal
Le projet vise à créer un framework pour simuler :
- La montée des usagers dans un transport à un arrêt
- Le déplacement du transport vers l'arrêt suivant
- La définition de différents caractères d'usagers
- La gestion des erreurs avec des informations sur le transport et l'usager

### 1.2 Concepts Clés
- **Usager**: Personne qui utilise le transport, caractérisée par un nom et une destination
- **Transport**: Véhicule avec un nombre maximal de places assises et debout
- **Arrêt**: Point d'arrêt ordonné, représenté par un nombre entier positif

### 1.3 Comportements des Usagers
À la montée :
- Peut choisir une place assise ou debout
- Peut choisir de ne pas monter (rester dehors)

À chaque arrêt :
- Peut changer de place (assis ↔ debout)
- Peut sortir du transport (même avant sa destination)

## 2. Architecture du Framework

### 2.1 Structure du Paquetage `tec`
Le framework est organisé dans le paquetage `tec` avec les éléments suivants :

#### Interfaces Publiques (utilisées par le client)
- `Usager`: Définit le type d'usager manipulé par le programme principal
- `Transport`: Définit le type de transport manipulé par le programme principal

#### Interfaces Privées (interactions internes)
- `Passager`: Définit les interactions avec le bus
- `Bus`: Définit les interactions avec les passagers

#### Classes d'Exception
- `UsagerInvalideException`: Gère les erreurs au niveau du client

### 2.2 Diagramme de Classes Simplifié
```
Usager (interface publique)
    ↑
PassagerStandard (classe concrète)
    ↑
Passager (interface privée)

Transport (interface publique)
    ↑
Autobus (classe concrète)
    ↑
Bus (interface privée)
```

## 3. Étapes de Développement

### 3.1 Première Itération : Mise en Place du Framework

#### Étape 1 : Inspection des Fichiers Sources
- Compiler les fichiers sources fournis
- Vérifier que tout compile correctement

#### Étape 2 : Ajout des Classes de Support
Deux classes sont nécessaires pour l'implémentation :
- `EtatPassager`: Pour gérer l'état des passagers (assis, debout, dehors)
- `JaugeNaturel`: Pour gérer le comptage des places dans le bus

Ces classes doivent être ajoutées au paquetage `tec` avec leurs tests.

#### Étape 3 : Création des Versions Minimales

**Pour PassagerStandard :**
- Faire partie du paquetage `tec`
- Être déclarée publique
- Implémenter les interfaces `Usager` et `Passager`
- Constructeur avec nom et destination
- Méthodes avec corps vide ou retour de base

**Pour Autobus :**
- Faire partie du paquetage `tec`
- Être déclarée publique
- Implémenter les interfaces `Transport` et `Bus`
- Constructeur avec nombre de places assises et debout
- Méthodes avec corps vide ou retour de base

#### Étape 4 : Tests d'Intégration
- Utiliser la classe `Simple.java` comme test d'intégration
- Corriger les erreurs jusqu'à compilation complète

### 3.2 Deuxième Itération : Implémentation Complète

#### Étape 1 : Implémentation de PassagerStandard

**Constructeur :**
```java
public PassagerStandard(String nom, int destination) {
    // Initialisation du nom, destination et état (dehors)
}
```

**Méthodes d'état :**
- `estAssis()`: Retourne vrai si le passager est assis
- `estDebout()`: Retourne vrai si le passager est debout
- `estDehors()`: Retourne vrai si le passager est dehors
- `non()`: Retourne vrai si le passager n'est pas dans le bus

**Méthodes de modification d'état :**
- `accepterPlaceAssise()`: Change l'état en assis
- `accepterPlaceDebout()`: Change l'état en debout
- `accepterSortie()`: Change l'état en dehors

**Méthodes de comportement :**
- `monterDans(Transport t)`: Cherche d'abord une place assise, sinon debout
- `nouvelArret(Bus bus, int numeroArret)`: Vérifie si sortie à destination

#### Étape 2 : Implémentation de Autobus

**Constructeur :**
```java
public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
    // Initialisation des compteurs de places
}
```

**Méthodes d'état :**
- `aPlaceAssise()`: Retourne vrai s'il reste des places assises
- `aPlaceDebout()`: Retourne vrai s'il reste des places debout

**Méthodes de gestion des passagers :**
- `demanderPlaceAssise(Passager p)`: Fait monter le passager en place assise
- `demanderPlaceDebout(Passager p)`: Fait monter le passager en place debout
- `demanderSortie(Passager p)`: Fait sortir le passager
- `demanderChangerEnAssis(Passager p)`: Change un passager de debout à assis
- `demanderChangerEnDebout(Passager p)`: Change un passager d'assis à debout

**Méthode de déplacement :**
- `allerArretSuivant()`: Notifie tous les passagers du nouvel arrêt

## 4. Tests et Validation

### 4.1 Tests Unitaires
Chaque classe doit avoir sa classe de test :
- `PassagerStandardTest`: Tests pour la classe PassagerStandard
- `AutobusTest`: Tests pour la classe Autobus

### 4.2 Test d'Intégration
La classe `Simple.java` sert de test d'intégration :
- Crée un autobus avec 1 place assise et 2 places debout
- Crée trois passagers avec différentes destinations
- Simule le trajet à travers plusieurs arrêts
- Affiche l'état du bus et des passagers à chaque arrêt

### 4.3 Résultat Attendu
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

## 5. Gestion des Erreurs

### 5.1 Exceptions Contrôlées
- `UsagerInvalideException`: Utilisée au niveau du client
- Contient des informations sur l'usager et le transport en cause

### 5.2 Exceptions Non Contrôlées
- Utilisées pour la gestion d'erreurs internes au paquetage

## 6. Bonnes Pratiques

### 6.1 Approche TDD (Test-Driven Development)
- Écrire les tests en parallèle du code
- Les tests doivent montrer l'adéquation entre le code et la spécification

### 6.2 Développement en Parallèle
- Les classes peuvent être développées en parallèle
- Utiliser des objets "faussaires" (mock objects) pour les tests indépendants

### 6.3 Documentation
- Ajouter les annotations JavaDoc pour toutes les classes et méthodes
- Produire la documentation "à la javadoc"

## 7. Conclusion

Ce projet met en œuvre plusieurs concepts importants de la programmation orientée objet :
- Interfaces publiques et privées
- Héritage et implémentation d'interfaces
- Gestion des exceptions
- Tests unitaires et d'intégration
- Développement itératif

La séparation claire entre les interfaces publiques (pour le client) et privées (pour les interactions internes) est essentielle pour maintenir une bonne architecture du framework.