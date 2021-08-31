package com.example.api.student;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {
    private final StudentService studentService; // если ставим final , то требует установить конструктор параметра

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")// в браузере появляется /students
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping(path = "item")
    public void add(@RequestBody Student student) { //@RequestBody - чтобы возвращалось в формате JSON
        studentService.add(student);
//        return studentService.list(); // убираем list, т.к. он нам в list пойдет как захардкоженный (неизменяемый) список,
//        в который мы ничего не добавляем. Добавляем void в метод, он ничего не возвращает нам, а добавляет новую запись в БД (или консоль)
    }

    @DeleteMapping(path = "item/{studentId}")
    public void delete (@PathVariable Long studentId) {
        studentService.delete(studentId);

    }
}



