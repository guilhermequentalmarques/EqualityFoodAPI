FROM maven:3.8.3-openjdk-17

WORKDIR /src

COPY . /api.jar
RUN mvn clean package -DskipTests

EXPOSE 9090

ENTRYPOINT ["java","-jar", "api.jar"]
