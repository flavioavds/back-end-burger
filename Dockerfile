# Use openjdk version 17 as the base image
FROM openjdk:17

# Define the JAR_FILE argument that will be passed during build
# Removed the 'out' path as it directory is not necessary
# Fixed typo in the ARG command, removed the space between ARG and the JAR_FILE variable name
# Changed the name the of JAR_FILE from 'the J JARAR_FILE' to 'JAR_FILE'
ARG JAR_FILE=artifacts/demo_jar/*.jar

# Copy the JAR_FILE to the app.jar file inside the container
COPY $JAR_FILE app.jar

# Expose port 8080 for the container to listen on
# This is assuming that the application inside the JAR file listens on port 8080
EXPOSE 3000

# Set the entrypoint command to run the Java application using the app.jar file
# Added the -Djava.security.egd flag to improve startup performance and avoid issues with /dev/urandom
# Fixed typo, added space after ENTRYPOINT
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
