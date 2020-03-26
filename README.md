## Krankenhaus README

![Java CI with Maven](https://github.com/WeVsVirusID1928/krankenhaus_freiwilliges_personal/workflows/Java%20CI%20with%20Maven/badge.svg)
This repository is a starting point for our project.

## Run the application

To start the application on your machine execute the `run.sh` script from from the project root:
```
 ./run.sh
```

This will spin up docker containers for the frontend application, backend application and database. You can verify that all containers are up and running with:
```
docker ps -f network=howtohelppeople_default
```

To stop all project related containers run:
```
docker-compose -p howtohelppeople down
```


## Seed data

Currently the postgres database will be initialized with seed data through the SQL statements given in  `backend/src/main/resources/data-postgres.sql`. This is configured by `spring.datasource.initialization-mode` in the `application.yml` application configuration.