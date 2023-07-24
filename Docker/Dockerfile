FROM openjdk:20-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]