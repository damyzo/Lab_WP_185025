package mk.ukim.finki.wp.lab.service;


import mk.ukim.finki.wp.lab.model.Teacher;

import java.time.LocalDate;
import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(Long id);

    Teacher save(String name, String surname, LocalDate dateOfEmployment);

}
