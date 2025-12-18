# Use Java 17 (same as your other services)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy jar from target folder
COPY target/*.jar app.jar

# Expose port (must match application.properties)
EXPOSE 8085

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
