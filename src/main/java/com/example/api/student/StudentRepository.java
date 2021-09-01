package com.example.api.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> { //JpaRepository расширяет PagingAndSortingRepository, который в свою очередь расширяет CrudRepository

    Optional<Student> findStudentByEmail(String email);
}
