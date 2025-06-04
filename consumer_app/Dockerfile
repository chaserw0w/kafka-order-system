#Trying a multi-stage build

#Step 1 - building a module 'consumer_app'
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /build
COPY . .
RUN mvn -pl consumer_app -am clean package

#Step 2 - runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /build/consumer_app/target/consumer_app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]