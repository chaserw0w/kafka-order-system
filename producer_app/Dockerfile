#Trying a multi-stage build

#Step 1 - building a module 'producer_app'
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /build
COPY . .
RUN mvn -pl producer_app -am clean package

#Step 2 - runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /build/producer_app/target/producer_app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]