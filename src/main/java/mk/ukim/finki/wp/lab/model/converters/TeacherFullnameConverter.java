package mk.ukim.finki.wp.lab.model.converters;

import mk.ukim.finki.wp.lab.model.TeacherFullname;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class TeacherFullnameConverter implements
        AttributeConverter<TeacherFullname, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(TeacherFullname teacherFullname) {
        if(teacherFullname == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        if(teacherFullname.getName() != null && !teacherFullname.getName().isEmpty()) {
           sb.append(teacherFullname.getName());
           sb.append(SEPARATOR);
        }

        if (teacherFullname.getSurname()!= null && !teacherFullname.getSurname().isEmpty()){
            sb.append(teacherFullname.getSurname());
        }

        return sb.toString();
    }

    @Override
    public TeacherFullname convertToEntityAttribute(String s) {
        if(s == null || s.isEmpty()){
            return null;
        }
        String[] pieces = s.split(SEPARATOR);

        if(pieces == null || pieces.length == 0){
            return null;
        }

        TeacherFullname teacherFullname = new TeacherFullname();
        String name = !pieces[0].isEmpty()?pieces[0]: null;
        if(s.contains(SEPARATOR)){
            teacherFullname.setName(name);
            if(pieces.length>=2 && pieces[1] != null){
                teacherFullname.setSurname(pieces[1]);
            }
        }else{
            teacherFullname.setName(name);
        }
        return teacherFullname;
    }
}
