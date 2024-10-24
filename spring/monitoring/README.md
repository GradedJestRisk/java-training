# README

Actuator root URL: [http://localhost:8090/monitoring](http://localhost:8090/monitoring)

## Healtcheck

URL: [http://localhost:8090/monitoring/health](http://localhost:8090/monitoring/health)

```shell
curl --silent http://localhost:8090/monitoring/health | jq
```

```json
{
  "status": "UP",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 502392610816,
        "free": 281738473472,
        "threshold": 10485760,
        "path": "~/java-training/spring/monitoring/.",
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

If you get a 503, it's because a dependency is down.
https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/production-ready-endpoints.html#_writing_custom_healthindicators


## Execute from jar

```shell
./gradlew build
java -jar build/libs/monitoring-0.0.1-SNAPSHOT.jar
```

## Execute from Docker

It will start on [another port](.env), to demonstrate injecting configuration from environment variable.

Build image
```shell
./gradlew build
docker build --build-arg JAR_FILE=build/libs/\*.jar --tag spring-monitoring .
```

Run image
```shell
docker rm java-monitoring-standalone
docker run --name java-monitoring-standalone --detach --publish $SPRING_HEALTHCHECK_PORT:$SPRING_HEALTHCHECK_PORT --env-file .env --volume ./container-configuration:/application/configuration spring-monitoring
```

Check it started
```shell
docker logs --follow java-monitoring-standalone
```

You'll get
```shell
Tomcat started on port 8092
```

Then check healthcheck
```shell
curl --silent http://localhost:8091/monitoring/health | jq
```

Stop it
```shell
docker stop java-monitoring-standalone
```

## Execute from Docker

It will start on [another port](.env), to demonstrate injecting configuration from environment variable.

```shell
docker compose up --wait monitoring
```

If unhealthy
```shell
docker logs --follow java-monitoring-1
docker exec java-monitoring-1 cat /app/config/application.yml
docker inspect --format "{{json .State.Health }}" java-monitoring-1
```

And
```shell
docker exec java-monitoring-1 sh -c "wget -q -O- http://localhost:8091/monitoring/health"
```

Beware than using `direnv` (using `.envrc` file) will [overwrite](https://docs.docker.com/compose/how-tos/environment-variables/envvars-precedence/) `.env` file usage !

> Set with either the environment attribute but with the value interpolated from your shell 
