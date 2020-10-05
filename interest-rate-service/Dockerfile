FROM openjdk:8
ADD target/interest-rate-service-1.0.jar interest-rate-service-1.0.jar
ENTRYPOINT [ "java","-jar","-Dspring.profiles.active=dev","interest-rate-service-1.0.jar" ]