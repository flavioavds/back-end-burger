
FROM openjdk:17            # Use the openjdk:17 image as the base image
V #OLUME Create /tmp a                volume in the /tmp directory
COPY target/*.jar app.jar  Copy # all the .jar files from the target directory to the app.jar file
EXPOSE 8080                # Expose port 8080 for communication
ENTRYPOINT ["java","-jar","/app.jar"]  # Execute the command "java -jar /app.jar" as the entrypoint
