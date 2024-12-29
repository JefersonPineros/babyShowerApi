FROM openjdk:17-slim

WORKDIR /app

COPY target/babyShowerApi-0.0.1-SNAPSHOT.jar /app/babyShowerApi-0.0.1-SNAPSHOT.jar

EXPOSE 3000

CMD [ "java", "-jar", "/app/babyShowerApi-0.0.1-SNAPSHOT.jar" ]