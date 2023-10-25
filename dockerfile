FROM openjdk:17

WORKDIR /src

COPY . /api.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar", "api.jar"]
