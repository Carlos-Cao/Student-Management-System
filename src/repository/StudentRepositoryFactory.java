package repository;

public class StudentRepositoryFactory {
    public static StudentRepository getStudentRepository() {
        return new InMemoryStudentRepository();
    }
}
