FROM openjdk

LABEL maintainer="b.olinger.software.solutions.1101@gmail.com"

EXPOSE 8080:8080

COPY target/fulldemo-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java"," -jar", "./fulldemo-0.0.1-SNAPSHOT.jar"]

