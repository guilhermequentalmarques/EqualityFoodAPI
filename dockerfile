FROM maven:3.8.3-openjdk-17 AS ApiEqualityFoodApplication

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=ApiEqualityFoodApplication /target/ApiEqualityFoodApplication-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar", "api.jar"]
