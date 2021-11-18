FROM maven:3.6.0-jdk-11-slim AS build

COPY . /app                                               

RUN mvn -f /app/pom.xml clean package -DskipTests                                     

FROM openjdk:11-jre-slim-buster                              

COPY --from=build /app/target/starter-0.0.1-SNAPSHOT.jar .         

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "starter-0.0.1-SNAPSHOT.jar"]  