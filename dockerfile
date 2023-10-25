FROM openjdk:17

WORKDIR /src

COPY . /src.java

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
