package mk.ukim.finki.wp.lab.model.exception;

public class CourseNameDescriptionAndTeacherNeededException extends RuntimeException{
    public CourseNameDescriptionAndTeacherNeededException() {
        super("You need to enter name, description and select Teacher.");
    }
}
