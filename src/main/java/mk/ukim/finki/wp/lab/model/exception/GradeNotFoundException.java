package mk.ukim.finki.wp.lab.model.exception;

public class GradeNotFoundException extends RuntimeException{
    public GradeNotFoundException(Long id){
        super(String.format("Grade with id: %d, does not exists,", id));
    }
}
