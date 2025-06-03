#Trying a multi-stage build

#Step 1 - building .jar
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package

#Step 2 - running a program
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/producer_app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]