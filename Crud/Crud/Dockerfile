FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Crud-0.0.1-SNAPSHOT.jar appCrud.jar
ENTRYPOINT ["java","-jar","/appCrud.jar"]