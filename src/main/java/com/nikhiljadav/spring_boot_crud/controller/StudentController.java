package com.nikhiljadav.spring_boot_crud.controller;

import com.nikhiljadav.spring_boot_crud.entity.Student;
import com.nikhiljadav.spring_boot_crud.exception.UserNotFoundException;
import com.nikhiljadav.spring_boot_crud.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudentRecord(){
        List<Student> listOfAllStudentRecord = studentService.getAllStudentRecord();
        return ResponseEntity.ok(listOfAllStudentRecord);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentRecordbyId(@PathVariable("id") long studentId) throws UserNotFoundException {
        Student studentRecord = studentService.getStudentRecordbyId(studentId);
        return ResponseEntity.ok(studentRecord);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudentRecord(@Valid @RequestBody Student student){
        Student createdStudent = studentService.createStudentRecord(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PostMapping(value = "/multi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>>createStudentRecord(@Valid @RequestBody List<Student> students){
        List<Student> createdStudents = studentService.createMultiStudentRecord(students);
        return ResponseEntity.ok(createdStudents);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudentRecordById(@PathVariable("id") Long studentId, @Valid @RequestBody Student student) throws UserNotFoundException {
        Student updatedStudentRecord = studentService.updateStudentRecordById(studentId, student);
        return ResponseEntity.ok(updatedStudentRecord);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteStudentRecordById(@PathVariable("id") long studentId){
        String deleteStudentStatusMsg = studentService.deleteStudentRecordById(studentId);
        return ResponseEntity.ok(deleteStudentStatusMsg);
    }
}
