FROM openjdk:latest
COPY ./target/SEMCourseWork-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMCourseWork-1.0-SNAPSHOT-jar-with-dependencies.jar"]