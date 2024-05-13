# DLQ-Patttern
Implementation einer exmaplarischen Dead-Letter Queue für die Zwischenspeicherung von Wahldaten im Falle des Ausfalls des Zielsystem am Wahltag.

# Allgemeine Infos

Das Projekt ist mit Spring Boot in vier Microservices umgesetzt. Als Dependencies werden Spring Web Services, eine h2 Database und Lombok verwendet.  Die h2 Datenbank wird nur während der Entwicklung verwendet

# Restful API

Die einzelnen Microservices nutzen zur Komunikation eine REST-API.
