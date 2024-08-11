package com.nikhiljadav.spring_boot_crud.service.serviceImpl;

import com.nikhiljadav.spring_boot_crud.entity.Student;
import com.nikhiljadav.spring_boot_crud.exception.UserNotFoundException;
import com.nikhiljadav.spring_boot_crud.repository.StudentRepository;
import com.nikhiljadav.spring_boot_crud.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudentRecord() {
        LOGGER.info("Inside getAllStudentRecord method");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentRecordbyId(long studentId) throws UserNotFoundException {
        LOGGER.info("Inside getStudentRecordbyId method");
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new UserNotFoundException("Student with ID " + studentId + " not found."));
    }

    @Override
    public Student createStudentRecord(Student student) {
        LOGGER.info("Inside createStudentRecord method");
        return studentRepository.save(student);
    }

    @Override
    public List<Student> createMultiStudentRecord(List<Student> students) {
        LOGGER.info("Inside createMultiStudentRecord method");
        return studentRepository.saveAll(students);
    }

    @Override
    public Student updateStudentRecordById(Long studentId, Student student) throws UserNotFoundException {
        LOGGER.info("Inside updateStudentRecordById method");
        Student fetchedStudentRecord = studentRepository.findById(studentId).orElseThrow(() -> new UserNotFoundException("Student with ID " + studentId + " not found."));
        if (Objects.nonNull(student)){
            fetchedStudentRecord.setFirstName(student.getFirstName());
            fetchedStudentRecord.setLastName(student.getLastName());
            fetchedStudentRecord.setPercentage(student.getPercentage());
            fetchedStudentRecord.setEmail(student.getEmail());
            fetchedStudentRecord.setPhoneNumber(student.getPhoneNumber());
        }
        return fetchedStudentRecord;
    }

    @Override
    public String deleteStudentRecordById(long studentId) {
        LOGGER.info("Inside deleteStudentRecordById method");
        studentRepository.deleteById(studentId);
        return String.format("Student record with student ID : %s is deleted successfully", studentId);
    }
}
