# Spring2022
## TP3 Springboot - Doctolib (Rdvs/Profs/Etudiants) 
La réalisation du TP3 en version swagger c'est trouve dans le branch :
```
spring-boot-sample-data-jpa-standalone
```
### Démarrage
Lancez votre base de donnée type MySql
Créez un nouvelle Database avec le nom:
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
L'API au démarrage peuple de base de données avec quelques exemples. Il permets de tester les requêtes de type
GET de tout débout. Testez les.
Pour créer, ouvrir un nouveau crénau d'un prof, choisissez le POST de RDV et saisissez les éléménts obligatoires
à remplir (prof id, date en format: dd/MM/yyyy, heure en String exemple: 10h-11h), puis l'exécutez.
Le nouveau créneau a le status OUVERT par default. L'etudiant parmis ces créneaus peut le modifier en mode PUT
en remplissant son id (ajutant son nom) et choisissant le status RESERVE.
Le status de RDV peut être modifier et mêttre en status ANNULE également par un prof ou par un étudiant.

### Aspect AOP
Avant et après de chaque requêtes exécutées un message type log apparaissent sur le console.
Par example en démarrant le requête de GET profs:
avant:
```
Executing execution(Collection sample.data.jpa.web.ProfController.getProfs())
```
aprés:
```
Complete execution of execution(Collection sample.data.jpa.web.ProfController.getProfs())
```
