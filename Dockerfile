FROM openjdk:8-alpine

ADD target/age-checker-service-swarm.jar /age-checker-service-swarm.jar

WORKDIR /
EXPOSE 8080

CMD ["java", "-jar", "age-checker-service-swarm.jar"]