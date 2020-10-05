FROM java:8
ADD target/fixed-deposit-service-1.0.jar fixed-deposit-service-1.0.jar
ENTRYPOINT [ "java","-Dspring.profiles.active=dev","-jar","fixed-deposit-service-1.0.jar" ]