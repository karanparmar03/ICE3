# Build Stage
FROM gradle:8-jdk23-alpine AS builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build -x test

# Package Stage
FROM openjdk:23-jdk

RUN mkdir /app

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/order-service.jar

# Set environment variables for database credentials
ENV POSTGRES_USER=admin \
    POSTGRES_PASSWORD=password

# Expose the port the service will run on
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "/app/order-service.jar"]
