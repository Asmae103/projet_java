# Plan de Travail pour Équipe de 3 Personnes - Projet Transports En Commun

## Répartition des Rôles

### Personne 1 : Chef de Projet / Intégrateur
- Responsable de la coordination globale
- Gestion de l'intégration des différentes parties
- Tests d'intégration et validation finale
- Documentation et rapports

### Personne 2 : Développeur Backend - Gestion des Passagers
- Implémentation des classes liées aux passagers
- Gestion des états et comportements des usagers
- Tests unitaires pour les classes de passagers

### Personne 3 : Développeur Backend - Gestion du Transport
- Implémentation des classes liées au transport
- Gestion des places et déplacements
- Tests unitaires pour les classes de transport

## Phase 1 : Initialisation (Jour 1)

### Tâches Communes (Toute l'équipe - 2 heures)
- [ ] Lecture et compréhension du cahier des charges
- [ ] Installation et configuration de l'environnement Eclipse
- [ ] Création du projet partagé (Git/SVN)
- [ ] Répartition formelle des tâches et planning détaillé

### Personne 1 : Chef de Projet
- [ ] Création du dépôt Git et configuration
- [ ] Mise en place du structure de branches (master, develop, feature/*)
- [ ] Configuration des outils de communication (Slack/Discord)
- [ ] Création du tableau de suivi (Trello/GitHub Projects)

### Personne 2 : Gestion des Passagers
- [ ] Analyse détaillée des interfaces Usager et Passager
- [ ] Création du squelette de la classe PassagerStandard
- [ ] Implémentation de la classe EtatPassager
- [ ] Premiers tests unitaires pour EtatPassager

### Personne 3 : Gestion du Transport
- [ ] Analyse détaillée des interfaces Transport et Bus
- [ ] Création du squelette de la classe Autobus
- [ ] Implémentation de la classe JaugeNaturel
- [ ] Premiers tests unitaires pour JaugeNaturel

## Phase 2 : Développement Initial (Jour 2-3)

### Personne 1 : Chef de Projet
- [ ] Intégration des classes de support dans le projet
- [ ] Mise en place de la classe Simple pour tests d'intégration
- [ ] Configuration de l'environnement de test continu
- [ ] Documentation de l'architecture

### Personne 2 : Gestion des Passagers
- [ ] Implémentation complète des méthodes d'état dans PassagerStandard
  - [ ] estAssis(), estDebout(), estDehors(), non()
- [ ] Implémentation des modificateurs d'état
  - [ ] accepterPlaceAssise(), accepterPlaceDebout(), accepterSortie()
- [ ] Tests unitaires pour toutes les méthodes d'état
- [ ] Code review des modifications

### Personne 3 : Gestion du Transport
- [ ] Implémentation des méthodes d'état dans Autobus
  - [ ] aPlaceAssise(), aPlaceDebout()
- [ ] Implémentation des gestionnaires de places
  - [ ] demanderPlaceAssise(), demanderPlaceDebout()
- [ ] Tests unitaires pour les méthodes d'état
- [ ] Code review des modifications

## Phase 3 : Développement Avancé (Jour 4-5)

### Personne 1 : Chef de Projet
- [ ] Premier test d'intégration avec Simple.java
- [ ] Identification des problèmes d'interaction
- [ ] Coordination des corrections entre les développeurs
- [ ] Mise à jour de la documentation

### Personne 2 : Gestion des Passagers
- [ ] Implémentation de la logique de montée dans PassagerStandard
  - [ ] monterDans(Transport t)
- [ ] Implémentation de la logique d'arrêt
  - [ ] nouvelArret(Bus bus, int numeroArret)
- [ ] Tests unitaires pour les méthodes de comportement
- [ ] Correction des bugs identifiés lors de l'intégration

### Personne 3 : Gestion du Transport
- [ ] Implémentation des changements de place
  - [ ] demanderChangerEnAssis(), demanderChangerEnDebout()
- [ ] Implémentation de la sortie des passagers
  - [ ] demanderSortie(Passager p)
- [ ] Implémentation du déplacement entre arrêts
  - [ ] allerArretSuivant()
- [ ] Tests unitaires pour toutes les méthodes de gestion

## Phase 4 : Intégration et Tests (Jour 6-7)

### Tâches Communes (Toute l'équipe - 4 heures)
- [ ] Fusion de toutes les branches de développement
- [ ] Résolution des conflits d'intégration
- [ ] Tests d'intégration complets avec Simple.java
- [ ] Correction des bugs rémanents

### Personne 1 : Chef de Projet
- [ ] Coordination de l'intégration finale
- [ ] Tests de régression complets
- [ ] Validation du résultat attendu
- [ ] Préparation de la documentation finale

### Personne 2 : Gestion des Passagers
- [ ] Tests unitaires complets pour PassagerStandard
- [ ] Tests de cas limites (passagers multiples, destinations variées)
- [ ] Correction des bugs liés aux passagers
- [ ] Documentation des classes de passagers

### Personne 3 : Gestion du Transport
- [ ] Tests unitaires complets pour Autobus
- [ ] Tests de cas limites (capacité maximale, arrêts multiples)
- [ ] Correction des bugs liés au transport
- [ ] Documentation des classes de transport

## Phase 5 : Finalisation (Jour 8)

### Tâches Communes (Toute l'équipe - 2 heures)
- [ ] Revue de code finale
- [ ] Tests d'acceptation complets
- [ ] Finalisation de la documentation
- [ ] Préparation de la présentation

### Personne 1 : Chef de Projet
- [ ] Compilation de la documentation finale
- [ ] Préparation du rapport de projet
- [ ] Vérification de la conformité avec les spécifications
- [ ] Archivage du projet final

### Personne 2 : Gestion des Passagers
- [ ] Finalisation des tests unitaires
- [ ] Documentation Javadoc complète pour les classes de passagers
- [ ] Vérification de la couverture de code
- [ ] Optimisation des performances si nécessaire

### Personne 3 : Gestion du Transport
- [ ] Finalisation des tests unitaires
- [ ] Documentation Javadoc complète pour les classes de transport
- [ ] Vérification de la couverture de code
- [ ] Optimisation des performances si nécessaire

## Plan de Travail Quotidien

### Matin (9h-12h)
- 30 min : Point d'équipe sur l'avancement
- 2h30 : Développement individuel selon les tâches du jour

### Après-midi (14h-17h)
- 2h : Développement individuel
- 1h : Code review et intégration

### Fin de journée (17h-17h30)
- 30 min : Bilan et planification du lendemain

## Outils de Collaboration

### Gestion de Version
- **Git** avec branches :
  - `master` : version stable
  - `develop` : développement en cours
  - `feature/passager-*` : développement lié aux passagers
  - `feature/transport-*` : développement lié au transport
  - `feature/integration-*` : travaux d'intégration

### Communication
- **Slack/Discord** pour communication quotidienne
- **Réunions quotidiennes** de 15-30 minutes
- **Code review** systématique avant fusion

### Suivi de Projet
- **Trello/GitHub Projects** pour suivre les tâches
- **Google Drive** pour partage de documents
- **Pastebin** pour partage de code temporaire

## Livrables

### Fin de Phase 1
- Structure de projet créée
- Classes de support implémentées
- Tests unitaires initiaux

### Fin de Phase 2
- Méthodes d'état implémentées
- Tests unitaires pour les états
- Première intégration fonctionnelle

### Fin de Phase 3
- Logique métier complète
- Tests unitaires complets
- Intégration quasi-fonctionnelle

### Fin de Phase 4
- Intégration complète
- Tests d'intégration validés
- Bugs résolus

### Fin de Phase 5
- Projet finalisé et documenté
- Tests d'acceptation validés
- Prêt pour la présentation

## Gestion des Risques

### Risques Techniques
- **Incompatibilité entre classes** : Tests d'intégration précoces
- **Performance** : Tests de charge si nécessaire
- **Bugs complexes** : Session de débogage en équipe

### Risques Organisationnels
- **Retard** : Réunions de suivi quotidiennes
- **Conflits** : Médiation par le chef de projet
- **Absence** : Documentation complète et partage des connaissances

## Critères de Succès

### Techniques
- [ ] Tous les tests unitaires passent
- [ ] Simple.java s'exécute correctement
- [ ] Résultat conforme aux spécifications
- [ ] Code documenté (Javadoc)

### Organisationnels
- [ ] Respect des délais
- [ ] Bonne collaboration d'équipe
- [ ] Documentation complète
- [ ] Présentation réussie

Ce plan de travail permet une répartition équilibrée des tâches tout en assurant une collaboration efficace et une intégration progressive du projet.