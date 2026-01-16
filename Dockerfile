FROM openjdk:17-jdk-slim

WORKDIR /apptarget/hidroponia-0.0.1-SNAPSHOT

COPY target/*.jar target/hidroponia-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "target/hidroponia-0.0.1-SNAPSHOT.jar"]
