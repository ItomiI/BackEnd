FROM amazoncorretto:19-alpine-jdk

copy target/proyecto-0.0.1-SNAPSHOT.jar app.jar

entrypoint ["java","-jar","/app.jar"]