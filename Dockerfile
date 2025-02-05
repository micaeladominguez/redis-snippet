FROM gradle:8.1.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/redis-snippets-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar","/app/redis-snippets-0.0.1-SNAPSHOT.jar"]
