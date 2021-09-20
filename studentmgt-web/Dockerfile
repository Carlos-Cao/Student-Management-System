FROM openjdk:latest
COPY ./target/studentmgt-web-0.0.1-SNAPSHOT.jar studentmgt-web-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE inMemoryStudentRepository
ENTRYPOINT ["java", "-jar", "studentmgt-web-0.0.1-SNAPSHOT.jar"]

