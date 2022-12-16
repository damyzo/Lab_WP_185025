package mk.ukim.finki.wp.lab.model.exception;

public class StudentAlreadyExistsException extends RuntimeException{
    public StudentAlreadyExistsException(String username){
        super(String.format("Student with username: %s, Already exists", username));
    }
}
