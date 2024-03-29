# Use fabric8's s2i Builder image.
# https://hub.docker.com/r/fabric8/s2i-java
FROM fabric8/s2i-java:2.0

# Service must listen to $PORT environment variable.
# This default value facilitates local development.
ENV PORT 8080

# Copy the JAR file to the deployment directory.
ENV JAVA_APP_DIR=/deployments
COPY target/starter-1.0.0-SNAPSHOT-fat.jar /deployments/
