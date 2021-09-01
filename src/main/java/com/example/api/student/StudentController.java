package com.example.api.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
// возвращает используемый метод HTTP-запроса @RequestMapping (method = RequestMethod.POST, GET, PUT и дp. запрос)
public class StudentController {
    private final StudentService studentService; // если ставим final, то требует установить конструктор параметра

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")// @GetMapping==@RequestMapping(method = RequestMethod.GET)
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping(path = "item")
    public void add(@RequestBody Student student) { //@RequestBody - чтобы возвращалось в формате JSON
        studentService.add(student);
    }

    @DeleteMapping(path = "item/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping(path = "item")
    public void update(@RequestBody Student student) {
        studentService.update(student);

    }
}



