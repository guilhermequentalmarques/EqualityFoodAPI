FROM openjdk:17

WORKDIR /src

COPY . app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
