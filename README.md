# School event / Calendrier associatif

Le but de ce projet est de réaliser un site qui rassemble l’ensemble des évènements associatifs d’une école/entreprise.

Le projet a été développé en Java avec le framework Spring pour le backend et en JavaScript avec le framework Angular pour le frontend.

## Fonctionnalités du projet
 - Visualisation de la liste des évènements associatifs selon le mois
 - Connexion/déconnexion pour les membres des associations pour poster des events
 - Connexion/déconnexion d’un administrateur pour gérer les associations

## Trois types d'utilisateur du site
- Les étudiants qui souhaitent avoir connaissance des évènements à venir, ils ont juste la possibilité de consulter les évènements avec les détails
- Les membres “communication” de chaque association qui se connecte via une adresse mail unique à l’association. Ils ont la possibilité d’ajouter, consulter, modifier et supprimer les posts évènement de l’association. (CRUD)
- L’administrateur du site, se connecte via des identifiants spéciaux. Il peut ajouter, consulter, modifier et supprimer les associations (CRUD)

## Post associatif

Le post associatif rassemble toutes les informations importantes sur l’évènement :
- Nom de l'évènement
- Catégorie de l'évènement
- Date
- Lieu
- Lien vers un moyen de paiement
- Description de l'évènement

## Maquettes
- [Accès aux maquettes Figma LoFi](https://www.figma.com/file/NPQVqnbXNo6p6DXdb66Y2J/Maquettes-Asso-calendar?node-id=0%3A1)

# Lancement du projet

## 1. Backend
- Ouvrir le dossier ```api``` dans IntelliJ
- Lancer Docker, puis initialiser la base de données avec la commande suite dans le cmd : 
```bash 
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 mariadb 
```
- Connecter la base de données avec les identifiants ci-dessus via l’onglet ```Database``` dans IntelliJ
- Exécution des deux scripts SQL ```1_TABLES.sql``` (structure des tables de la base de données) et ```2_DEFAULT_ENTRIES.sql``` (insertion d’un jeu de données)
- Exécuter l’application et ouvrir une page web ```http://localhost:8080/posts``` pour visualiser les données dans le back

## 2. Frontend
- Ouvrir le dossier ```front``` dans l’IDE de votre choix
- Lancer la commande ```npm i``` pour installer toutes dépendances du projet dans le fichier ```package.json```
- Afin de pouvoir accéder au site en local, démarrer le serveur dans un cmd la commande suivante depuis le dossier ```front``` : ```ng serve```
- Accéder au site en local depuis l’adresse ```http://localhost:4200/```