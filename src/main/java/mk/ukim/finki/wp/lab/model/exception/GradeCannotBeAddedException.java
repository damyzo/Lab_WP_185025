package mk.ukim.finki.wp.lab.model.exception;

public class GradeCannotBeAddedException extends RuntimeException{
    public GradeCannotBeAddedException(){
        super("Grade cannot be added.");
    }
}
