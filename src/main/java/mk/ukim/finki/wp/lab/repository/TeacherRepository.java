package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TeacherRepository {
    public List<Teacher> findAll(){
        return DataHolder.teachers;
    }

    public Teacher save(Teacher teacher)
    {
        DataHolder.teachers
                .removeIf(
                        i -> i.getName().equals(teacher.getName())
                                && i.getSurname().equals(teacher.getSurname()));
        DataHolder.teachers.add(teacher);
        return teacher;
    }

    public void deleteById(Long id)
    {
        DataHolder.teachers.removeIf(i -> i.getId().equals(id));
    }
}
