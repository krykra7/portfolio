FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
COPY local/application.yml .
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]
