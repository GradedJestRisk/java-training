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
java -jar build/libs/monitoring-0.0.1-SNAPSHOT.jar
```

## Execute from Docker

Build image
```shell
docker build --build-arg JAR_FILE=build/libs/\*.jar --tag spring-monitoring .
```

Run image
```shell
docker run --publish 8090:8090 spring-monitoring
```

## Execute from Docker
```shell
docker compose up --wait monitoring 
```

If unhealthy
```shell
docker inspect --format "{{json .State.Health }}" java-monitoring-1
```