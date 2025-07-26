FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/broker-1.0.0.jar /app/broker.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/broker.jar"]
