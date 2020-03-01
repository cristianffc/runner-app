FROM openjdk:11-jre-slim
VOLUME /tmp
COPY build/libs/*.jar runner.jar
ENTRYPOINT ["java","-jar","/runner.jar"]