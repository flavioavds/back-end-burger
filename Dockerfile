
# Dockerfile content with comments

# Use openjdk version 17 as the base image
FROM openjdk:17

# Define the JAR_FILE argument that will be passed during build
ARG JAR_FILE=out/artifacts/demo_jar/*.jar

# Copy the JAR_FILE to the app.jar file inside the container
COPY ${JAR_FILE} app.jar

# Expose port 8080 for the container to listen on
# This is assuming that the application inside the JAR file listens on port 8080
EXPOSE 8080

# Set the entrypoint command to run the Java application using the app.jar file
ENTRYPOINT ["java","-jar","/app.jar"]
