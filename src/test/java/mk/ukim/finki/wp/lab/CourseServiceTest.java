package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.TeacherFullname;
import mk.ukim.finki.wp.lab.model.Type;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.service.impl.CoursesServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {
    @Mock
    private  CourseRepositoryJpa courseRepository;
    @Mock
    private  StudentRepositoryJpa studentRepository;

    @Mock
    private  GradeRepositoryJpa gradeRepositoryJpa;
    private CoursesServiceImpl coursesService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        coursesService = Mockito.spy(new CoursesServiceImpl(courseRepository,studentRepository,gradeRepositoryJpa));
    }

    @Test
    public void testDelete(){
        Assert.assertFalse(coursesService.deleteById(1L));
    }
}
