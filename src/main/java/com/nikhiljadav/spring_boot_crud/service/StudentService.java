package com.nikhiljadav.spring_boot_crud.service;

import com.nikhiljadav.spring_boot_crud.entity.Student;
import com.nikhiljadav.spring_boot_crud.exception.UserNotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudentRecord();

    Student getStudentRecordbyId(long studentId) throws UserNotFoundException;

    Student createStudentRecord(Student student);

    List<Student> createMultiStudentRecord(List<Student> students);

    Student updateStudentRecordById(Long studentId, Student student) throws UserNotFoundException;

    String deleteStudentRecordById(long studentId);
}
