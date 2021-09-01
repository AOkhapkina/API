package com.example.api.student;

import com.example.api.exception.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //используется с классами, которые предоставляют некоторые бизнес-функции, can be applied only to classes.
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();// This returns a JSON or XML with the users
    }

    public void add(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent())
            throw new RestApiException("Email is busy");
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());
        if (row.isPresent()) {
            Student item = row.get();
            if (!student.getName().isEmpty()) {
                item.setName(student.getName());
            }
            if (student.getBdate() != null) {
                item.setBdate(student.getBdate());
            }
            studentRepository.save(item);
        }
    }
}

