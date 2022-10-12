# Spring2022
## TP3 Springboot - Doctolib (Rdvs/Profs/Etudiants) 
Le réalisation du TP3 de version swagger c'est trouve dans le branch :
```
spring-boot-sample-data-jpa-standalone
```

### Démarrage
Lancer votre base de donnée type MySql
Créez un nouvelle Database :
```
testspringdata
```
Build le project puis lancez l'application par la méthode main de SampleDataJpaApplication.
Le Tomcat intégré se démarre automatiquement sous port: 8080
Ouvriéz votre navigateur et saisissez l'url suivant:
```
http://localhost:8080/swagger-ui/index.html
```

Swagger vous offre une liste de HTTP protocols pour tester la bonne fonctionnement de l'application
facilement.
L'API au démarrage a peuplé de base de données avec quelques exemples. Il s'agit que tous les requêtes type
GET fonctionnent déjà. Testez les.
Pour créer, ouvrir un nouveau crénau d'un prof, choisissez le POST de RDV et saisissez les éléménts obligatoires
à remplir (prof id, date en format: dd/MM/yyyy, heure en String exemple: 10h-11h), puis l'exécutez.
Le nouveau créneau a le status OUVERT par default. L'etudiant parmis ces créneaus peut le modifier en mode PUT
en remplissant son id (ajutant son nom) et choisissant le status RESERVE.
Le status de RDV peut mêttre en ANNULE également par un prof ou par un étudiant.
