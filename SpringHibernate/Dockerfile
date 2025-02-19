# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/SpringReact-0.0.1-SNAPSHOT.jar /app/SpringReact.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "SpringReact.jar"]

