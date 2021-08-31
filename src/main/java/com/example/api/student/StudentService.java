package com.example.api.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service //используется с классами, которые предоставляют некоторые бизнес-функции, can be applied only to classes.
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getListOfAll() {
        return studentRepository.findAll();
//        return List.of(
//                new Student("Alex", LocalDate.of(2000, Month.JANUARY, 1)),
//                new Student("Tom", LocalDate.of(2002, Month.NOVEMBER, 11)));//захаркоженный список, меняем его на return studentRepository.findAll(); - вытянуть весь список
    }

    public void addNew(Student student) {
         studentRepository.save(student);
    }

//    public void add(Student student) {
//    }
}

