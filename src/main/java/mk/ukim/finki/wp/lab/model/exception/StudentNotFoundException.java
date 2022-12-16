package mk.ukim.finki.wp.lab.model.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String username){
        super(String.format("Student with username: %s, does not exist.",username));
    }
}
