package mk.ukim.finki.wp.lab.model.exception;

public class StudentUsernamePasswordNameSurnameRequired extends RuntimeException{
    public StudentUsernamePasswordNameSurnameRequired(){
        super("Student username, password, name, surname required");
    }
}
