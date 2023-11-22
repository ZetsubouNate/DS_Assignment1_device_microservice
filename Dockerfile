FROM openjdk:22-slim

COPY target/DS_Assignment1_device_microservice-0.0.1-SNAPSHOT.jar ./app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
