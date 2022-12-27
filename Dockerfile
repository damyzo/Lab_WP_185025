FROM openjdk:19-jdk-alpine
ARG JAR_FILE=/home/runner/work/Lab_WP_185025/Lab_WP_185025/target/lab-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
