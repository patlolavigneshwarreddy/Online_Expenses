# ---- Build Stage ----
FROM maven:3.9.12-eclipse-temurin-21 AS build
WORKDIR /home/app

# Copy Maven pom and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# ---- Run Stage ----
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /home/app/target/*.jar app.jar

# Optional
VOLUME /tmp
EXPOSE 8888

# Start the application
ENTRYPOINT ["java","-jar","app.jar"]
