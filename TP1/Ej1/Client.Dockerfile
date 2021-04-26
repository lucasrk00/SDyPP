FROM openjdk:latest
COPY target/Ej1-1.0-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src/
ENTRYPOINT ["java", "-cp", "app.jar", "app.Client", "127.0.0.1", "4000"]