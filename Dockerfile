# Use the official Tomcat 9 image as the base
FROM tomcat:9.0-jdk21-openjdk-slim

# Remove the default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the webapp folder contents into the ROOT context of Tomcat
# This ensures the app is available at the root URL (e.g., https://your-app.onrender.com/)
COPY src/main/webapp/ /usr/local/tomcat/webapps/ROOT/

# Copy the compiled Java classes
# Eclipse puts classes in build/classes
COPY build/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

# Expose port 8080 (standard for Tomcat and Render)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
