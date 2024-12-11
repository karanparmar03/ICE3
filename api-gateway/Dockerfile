# Build Stage
FROM gradle:8-jdk23-alpine AS builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build -x test

# Package Stage
FROM openjdk:23-jdk

RUN mkdir /app

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/api-gateway.jar


EXPOSE 9000

# Run the application
ENTRYPOINT ["java", "-jar", "/app/api-gateway.jar"]
