FROM openjdk:17

COPY . /angel

ENTRYPOINT ["java", "-jar", "angel/target/blade-0.0.1-SNAPSHOT.jar"]