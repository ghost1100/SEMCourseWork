FROM openjdk:latest
COPY ./target/SEMCourseWork-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMCourseWork-0.1.0.1-jar-with-dependencies.jar"]