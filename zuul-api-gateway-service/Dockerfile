FROM openjdk:8
ADD target/zuul-api-gateway-service-1.0.jar zuul-api-gateway-service-1.0.jar
ENTRYPOINT [ "java","-jar","-Dspring.profiles.active=dev","zuul-api-gateway-service-1.0.jar" ]