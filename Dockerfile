FROM openjdk:8

ADD ./target/demo-0.0.1-SNAPSHOT.jar denom.jar
ENTRYPOINT java -jar denom.jar