package com.example.springstudentwebapp;

import com.example.springstudentwebapp.model.Student;
import com.example.springstudentwebapp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class SpringStudentWebappApplicationTests {

    @Autowired
    StudentRepository studentRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Velvet");
        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now());
        std2.setName("Jack");
        studentRepository.save(std2);

        List<Student> lst = studentRepository.findAll();
        assertEquals(2, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();

        assertEquals(1, lst.size());

        studentRepository.deleteAll();

        assertEquals(0, lst.size());


    }


}
