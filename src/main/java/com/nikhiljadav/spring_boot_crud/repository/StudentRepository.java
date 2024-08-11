package com.nikhiljadav.spring_boot_crud.repository;

import com.nikhiljadav.spring_boot_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
