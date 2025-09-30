FROM openjdk:latest
COPY ./target/SeMethods-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods-1.0-SNAPSHOT-jar-with-dependencies.jar"]