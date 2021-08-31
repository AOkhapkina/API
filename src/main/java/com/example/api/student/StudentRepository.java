package com.example.api.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> { //JpaRepository расширяет PagingAndSortingRepository, который в свою очередь расширяет CrudRepository
//CrudRepository – базовый набор операций над сущностями: создание, чтение, изменение и удаление (CRUD).
// PagingAndSortingRepository – добавляет к CRUD возможность постраничной загрузки данных с определенной сортировкой.
// JpaRepository – добавляет к PagingAndSortingRepository функции очистки контекста сохраняемости и удаления записей в пакете, полноценно реализует Java Persistence API.,

}
