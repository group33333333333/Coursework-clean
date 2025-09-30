FROM openjdk:latest
COPY ./target/SeMethods-0.1.0.2-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SeMethods-0.1.0.2-SNAPSHOT-jar-with-dependencies.jar"]