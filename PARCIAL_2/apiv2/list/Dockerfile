FROM openjdk:17-jdk-alpine

COPY target/list-0.0.1-SNAPSHOT.jar java-app.jar

ENTRYPOINT ["java", "-jar", "java-app.jar"]

EXPOSE 8094