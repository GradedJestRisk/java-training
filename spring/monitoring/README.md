# README

Actuator root URL: [http://localhost:8090/monitoring](http://localhost:8090/monitoring)

## Healtcheck

URL: [http://localhost:8090/monitoring/health](http://localhost:8090/monitoring/health)

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