package com.example.api.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "bdate")
    private LocalDate bdate;

    public Student(String name, String email, LocalDate bdate) {
        this.name = name;
        this.email = email;
        this.bdate = bdate;
    }

    public int getAge() { //не создаем переменную и не добавляем в БД, возраст отобразится только в ответе в формате JSON
        return Period.between(bdate, LocalDate.now()).getYears();
    }

}
