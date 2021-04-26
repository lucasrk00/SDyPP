FROM openjdk:latest
COPY target/Ej5-1.0-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src/
ENTRYPOINT ["java", "-cp", "app.jar", "app.Server", "4000"]
