# base image
FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
VOLUME /tmp
EXPOSE 8080
ADD target/employee-management-system-0.0.1-SNAPSHOT.jar employee-management-system-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/employee-management-system-0.0.1-SNAPSHOT.jar"]


