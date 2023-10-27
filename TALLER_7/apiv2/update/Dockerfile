FROM openjdk:17-jdk-alpine
COPY target/update-0.0.1-SNAPSHOT.jar java-update-app.jar
ENTRYPOINT ["java", "-jar", "java-update-app.jar"]