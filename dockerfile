FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
COPY --from=build /target/api_equality_food-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 9192
ENTRYPOINT ["java","-jar","api.jar"]
