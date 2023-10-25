FROM maven:3.8.3-openjdk-17 AS ApiEqualityFoodApplication

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY . api.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar", "api.jar"]
