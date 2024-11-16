# studentManagement-kawtar
Description
Ce projet est une application de gestion des étudiants construite avec Spring Boot. Il permet de gérer les données des étudiants, en se focalisant sur les fonctionalités suivantes: Récupérer tous les étudiants Obtenir le nombre total d'étudiants Trier les étudiants par année Ajouter un nouvel étudiant Supprimer un étudiant par ID

Prérequis
Java 17 .
Maven 3.8+ pour la gestion des dépendances.
MySQL pour la base de données.
Un IDE comme IntelliJ IDEA .
Dépendances principales Spring Boot Starter Web : pour construire l'API REST. Spring Boot Starter Data JPA : pour la gestion des données. MySQL Connector : pour connecter l'application à MySQL. Springdoc OpenAPI : pour la documentation API. Spring Boot DevTools (optionnel) : pour le rechargement automatique en développement.

Exemple d'EndPoints

Ajouter un étudiant POST /students Body (JSON) { "nom": "kawtar abderrazak", "email": "kawtar.abderrazak1@gmail.com", "age": 22 } Obtenir la liste des étudiants GET /students

Mettre à jour un étudiant PUT /students/{id} Body (JSON) : { "nom": "kawtar abderrazak", "email": "kawtar.abderrazak1@gmail.com", "age": 22 }

Supprimer un étudiant DELETE /students/{id}



