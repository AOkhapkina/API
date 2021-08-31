package com.example.api.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter // при формировании JSON ответа, запрос идет на get field (getters), поэтому добавляем аннотацию lombok или генерируем геттеры
@ToString
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence", sequenceName = "student_sequence")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    @Column (name = "id")
    private Long id;
//    private String name;
//    private LocalDate birthdate;
    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    public int getAge (){ //не создаем переменную и не добавляем в БД, возраст отобразится только в ответе в формате JSON
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public Student(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
}
