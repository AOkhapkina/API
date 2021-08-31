package com.example.api.student;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
@Data// при формировании JSON ответа, запрос идет на get field (getters), поэтобу добавляем аннотацию lombok ли генерируем геттеры
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name="student_sequence", sequenceName = "student_sequence")
    private Long id;
    private String name;
    private LocalDate birthDate;

    public Student(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

}
