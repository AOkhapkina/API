package com.example.api.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {
    private final StudentService studentService; // если ставим final , то требует установить конструктор параметра

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")// в браузере появляется /students
    public List<Student> getList() {
        return studentService.getListOfAll();
    }

    @PostMapping(path = "item")
    public void add(@RequestBody Student student) { //@RequestBody - тобы возвращалось в формате JSON
        studentService.addNew(student);
//        return studentService.list(); // убираем list, т.к. он нам в list пойдет как захардкоженный (неизменяемый) список, вкоторый мы ничего не добавляем
//        и добавляем void в метод, он ничего не возвращает нам
    }
}



