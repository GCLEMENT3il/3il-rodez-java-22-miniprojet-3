Pour démarrer le jeu, il faut lancer le fichier DifficultySelection.java.

# Structure du Projet

Ce projet est une application de jeu de devinettes de mots, construite en utilisant le langage de programmation Java. Le projet suit le modèle de conception MVC (Modèle-Vue-Contrôleur) et utilise également le modèle de conception Singleton.

## Modèle-Vue-Contrôleur (MVC)

Le modèle MVC est un modèle de conception qui divise une application en trois parties interconnectées. Cela permet de séparer les préoccupations internes de l'application, ce qui rend le projet plus organisé et plus facile à gérer.

- **Modèle** : Il s'agit de la couche de données de l'application. Dans ce projet, les classes `Partie` et `Mot` agissent comme le modèle.

- **Vue** : Il s'agit de la couche de présentation de l'application. Dans ce projet, la classe `VueJeu` agit comme la vue.

- **Contrôleur** : Il s'agit de la couche qui gère la logique de l'application. Dans ce projet, la classe `ControleurJeu` agit comme le contrôleur.

## Singleton

Le modèle de conception Singleton garantit qu'une classe n'a qu'une seule instance et fournit un point d'accès global à cette instance. Dans ce projet, la classe `OptionDujeu` utilise le modèle de conception Singleton.

## Classes

### `Partie.java`

Cette classe représente une partie du jeu. Elle contient le mot à deviner, le nombre maximum de tentatives et le nombre de tentatives restantes.

### `Mot.java`

Cette classe représente un mot dans le jeu. Elle contient le mot lui-même et sa définition.

### `VueJeu.java`

Cette classe représente la vue dans le modèle MVC. Elle contient tous les éléments de l'interface utilisateur et gère l'affichage de l'application.

### `ControleurJeu.java`

Cette classe représente le contrôleur dans le modèle MVC. Elle gère la logique du jeu, y compris le démarrage d'une nouvelle partie, la soumission d'une lettre et la réinitialisation du jeu.

### `DifficultySelection.java`

Cette classe permet à l'utilisateur de sélectionner la difficulté du jeu. Elle contient une boîte de sélection pour choisir la difficulté et un bouton pour commencer le jeu.

### `LectureFichier.java`

Cette classe est utilisée pour lire les mots et les définitions à partir d'un fichier.

### `Main.java`

Cette classe est le point d'entrée de l'application. Elle crée une instance de `VueJeu` et `ControleurJeu`, et affiche la vue.

### `OptionDujeu.java`

Cette classe utilise le modèle de conception Singleton pour stocker les options du jeu, comme le temps de la partie. Elle fournit un point d'accès global à ces options.

### `PartieTest.java`

Cette classe contient des tests unitaires.


Voici le texte mis en forme en Markdown avec chaque ligne dans un tableau et les colonnes "Fait ou Pas Fait" et "Observation" ajoutées :

| Tâche | Fait ou Pas Fait | Observation                                                           |
|-------|------|-----------------------------------------------------------------------|
| Lecture aléatoire d'un mot à deviner à partir d'un fichier texte donné à la racine du projet. | Fait | -                                                                     |
| Affichage graphique de l'interface du jeu à l'aide de Swing. | Fait | -                                                                     |
| Affichage graphique du pendu qui évolue en fonction des erreurs du joueur. | Fait a moitié | - Fait, mais il faut mettre les bonnes images de l'évolution du pendu |
| Affichage graphique des lettres déjà proposées par le joueur. | Fait | -                                                                     |
| Affichage (ou non) de la définition (niveau de difficulté). | Fait | -                                                                     |
| Utilisation (ou non) d'un timer (niveau de difficulté). | Fait | -                                                                     |
| Gestion des entrées utilisateur pour proposer des lettres. | Fait | -                                                                     |
| Vérification de la validité des entrées utilisateur (lettre de l'alphabet uniquement). | Fait | - Prend les lettres de "A à Z", "-", "é"                               |
| Gestion du décompte des tentatives restantes. | Fait | -                                                                     |
| Gestion de la victoire ou de la défaite du joueur. | Fait | -                                                                     |
| Possibilité de rejouer une partie après la fin d'une partie. | Fait | -                                                                     |