package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {


    public List<Student> findAllStudents(){
        return DataHolder.studentList;
    }


    public List<Student> findAllByNameOrSurname(String text){
        return DataHolder.studentList.stream().filter(r -> r.getName().contains(text) || r.getSurname().contains(text)).collect(Collectors.toList());
    }
}
