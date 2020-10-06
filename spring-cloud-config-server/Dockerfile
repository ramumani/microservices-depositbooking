FROM openjdk:8
ADD target/spring-cloud-config-server-1.0.jar spring-cloud-config-server-1.0.jar
ENTRYPOINT [ "java","-jar","-Dspring.profiles.active=dev","spring-cloud-config-server-1.0.jar" ]