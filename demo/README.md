# Exécution et présentation du projet

## Instalation et éxecution

Executez le fichier run.sh se trouvant dans ce avec dossier `sh run.sh` ou `./run.sh`. En cas de problème, se référer à la section [problème connus](#problèmes-connus).

Ce script compile le backend avec maven puis crée l'image docker. Ensuite il crée l'image docker pour le frontend (consumer/web). Enfin, il éxecute [le fichier docker compose.](docker-compose.yml)

Un front end sera alors disponible sur http://localhost:8081/ (Il est possible que le front end mette un peu de temps à démarrer)

## Fonctionalités

Avec l'interface, les éléments du CRUDs sont disponible:

- Créer un nouveau meme avec le bouton "Créer"
- Visualiser tout les memes depuis la page principale
- Visualiser un meme en particulier en cliquant dessus
  - Supprimer le meme en cours de visualisation
  - Editer le meme en cours de visualisation

## Problèmes connus

Si dessous, une liste de problèmes que nous avons rencontré et leur solution.

- Si `run.sh`est éxecuté avec `sudo` il peut y avoir une erreur provenant de maven. (Aucune idée de pourquoi). Il ne faut donc pas utiliser sudo pour l'éxecution du script.
- Si on est sur la fenetre d'édition d'un meme et que l'on clique sur le bouton créer, la page sera toujours en mode édition. Il faut alors cliquer d'abord sur *Home* puis sur *Créer*.