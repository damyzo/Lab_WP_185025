FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
ENTRYPOINT ["./mvnw" ,"dependency:resolve"]
COPY src ./src
ENTRYPOINT ["./mvnw","spring-boot:run"]