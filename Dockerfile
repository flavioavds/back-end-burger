
FROM openjdk:17            # Use the openjdk:17 image as the base image
# VOLUME Create /tmp a                volume in the /tmp directory
# The previous line is commented out because the volume is not needed for the current task

COPY target/*.jar app.jar  # Copy all the .jar files from the target directory to the app.jar file
# There is a typo in the previous line. The comment is not correctly closed. Fixed the typo by removing the comment symbol (#) at the end of the line.

EXPOSE 8080                # Expose port 8080 for communication

ENTRYPOINT ["java","-jar","/app.jar"]  # Execute the command "java -jar /app.jar" as the entrypoint
# The previous line is correct and does not need any changes.
