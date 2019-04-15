Edge API
------

Provide Web proxy for other Edge services

### Edge API Proxy

The service listen on Vert.x's discover events.

When a API is detected, the proxy load the swagger configuration file, and mount automatically the API on his subpath.
All calls are redirect via the Vert.x event bus, using  [Web API Service](https://vertx.io/docs/vertx-web-api-service/java/)

### Third party API

In progress

