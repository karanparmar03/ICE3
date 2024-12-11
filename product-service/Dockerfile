# Build Stage
FROM gradle:8-jdk23-alpine AS builder

# Copy source code and set working directory
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Build the project without running tests
RUN gradle build -x test --info

# Package Stage
FROM openjdk:23-jdk

# Create an app directory
RUN mkdir /app

# Copy the JAR file generated from the build stage
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/product-service.jar

# Set environment variables for MongoDB
ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password


EXPOSE 8083

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]
