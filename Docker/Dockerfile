FROM maven:3.9.3-amazoncorretto-20 AS builder

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn clean package -Dmaven.test.skip

FROM openjdk:20-jdk-slim

COPY --from=builder target/notif-0.0.1-SNAPSHOT.jar notif-0.0.1-SNAPSHOT.jar

EXPOSE 8081

CMD ["java", "-jar", "notif-0.0.1-SNAPSHOT.jar"]