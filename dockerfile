FROM openjdk:17

WORKDIR /src

COPY . /src.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
