FROM openjdk:latest
COPY ./target/studentmgt-cli-0.0.1-SNAPSHOT.jar studentmgt-cli-0.0.1-SNAPSHOT.jar
ENV SPRING_PROFILES_ACTIVE inMemoryStudentRepository
ENTRYPOINT ["java", "-jar", "studentmgt-cli-0.0.1-SNAPSHOT.jar" ]