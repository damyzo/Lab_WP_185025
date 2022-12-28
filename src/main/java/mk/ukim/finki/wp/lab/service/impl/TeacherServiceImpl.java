package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exception.TeacherNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepositoryJpa;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepositoryJpa teacherRepository;

    public TeacherServiceImpl(TeacherRepositoryJpa teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        if(teacherRepository.findById(id).isPresent())
        {
            return teacherRepository.findById(id).get();
        }
        throw new TeacherNotFoundException(id);
    }

    @Override
    public Teacher save(String name, String surname, LocalDate dateOfEmployment) {
        return teacherRepository.save(new Teacher(name,surname,dateOfEmployment));
    }


}
