FROM openjdk:17

WORKDIR /src

COPY . .

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
