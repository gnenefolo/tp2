FROM openjdk:11
CMD mkdir /webapp
WORKDIR /webapp
EXPOSE 8080
COPY target/demo-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
