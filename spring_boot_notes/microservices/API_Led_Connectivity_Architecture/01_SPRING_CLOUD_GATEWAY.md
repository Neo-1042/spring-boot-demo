# Spring Cloud Gateway

Spring Cloud Gateway only "redirects" ("routes" is the
correct verb) when a route definition matches the incoming
request (via **predicates**) and then forwards it to a
configured URI (often `lb://SERVICE-ID`), otherwise, the
gateway itself returns a "404 no Route Found".

Spring Cloud Gateway is explicitly designed around
**routes + predicates + filters** configured in the
application.yml/properties file.

