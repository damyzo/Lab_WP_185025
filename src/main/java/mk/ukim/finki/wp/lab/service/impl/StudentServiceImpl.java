package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.exception.StudentAlreadyExistsException;
import mk.ukim.finki.wp.lab.model.exception.StudentUsernamePasswordNameSurnameRequired;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryJpa studentRepository;

    public StudentServiceImpl(StudentRepositoryJpa studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .filter(i -> i.getName().contains(text) || i.getSurname().contains(text))
                .collect(Collectors.toList());
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        if(username != null && !username.isEmpty() &&
                password != null && !password.isEmpty() &&
                name != null && !name.isEmpty() &&
                surname != null && !surname.isEmpty()
        )   {
            if(studentRepository.findById(username).isPresent())
            {
                throw new StudentAlreadyExistsException(username);
            }
            return studentRepository.save(new Student(username,password,name,surname));
        }

        throw new StudentUsernamePasswordNameSurnameRequired();
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findById(username).get();
    }
}
