package com.example.springstudentwebapp.config;

import com.example.springstudentwebapp.model.Student;
import com.example.springstudentwebapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setBornTime(LocalTime.now());
        std1.setName("Marvus");

        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now().plusDays(256));
        std2.setName("Aradia");

        studentRepository.save(std2);




    }
}
