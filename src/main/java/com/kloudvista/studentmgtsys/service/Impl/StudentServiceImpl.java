package com.kloudvista.studentmgtsys.service.Impl;

import com.kloudvista.studentmgtsys.domain.Student;
import com.kloudvista.studentmgtsys.dto.MessageResp;
import com.kloudvista.studentmgtsys.dto.NewStudent;
import com.kloudvista.studentmgtsys.repository.StudentRepository;
import com.kloudvista.studentmgtsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String NewStudent(NewStudent student) {
        //Check if student Exist
        //Generate ID
        //String uniqueID = UUID.randomUUID().toString();

        String studentId =
                String.valueOf(System.currentTimeMillis());
        Student newStudent = Student.builder()
                .reference(studentId)
                .email(student.getEmail())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .status(false)
                .phoneNumber(student.getPhoneNumber())
                .dateCreated(LocalDateTime.now())
                .build();

        //Same newStudent
        Student save = studentRepository.save(newStudent);
        return studentId;
    }

    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
    public Student findStudentByRef(String studentId) {
        return studentRepository.findByReference(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public MessageResp updateStudent(NewStudent newStudent) {
        Student student = studentRepository.findByReference(newStudent.getReference());
        if (student == null) {
            return new MessageResp("Student does not exist", "00");
        }
        student.setEmail(newStudent.getEmail());
        student.setLastName(newStudent.getLastName());
        student.setFirstName(newStudent.getFirstName());
        student.setDateUpdated(LocalDateTime.now());
        studentRepository.save(student);
        return new MessageResp("Successful", "00", student);

    }

    @Override
    public int deleteStudent(String reference) {
        int i = studentRepository.deleteStudent(reference);
        return i;
    }

    @Override
    public MessageResp activateStudent(String reference) {
        Student student = studentRepository.findByReference(reference);
        if (student == null) {
            return new MessageResp("Student does not exist", "00");
        }
        if (student.isStatus() == true) {
            return new MessageResp("Student is already active", "00");
        } else {
            int i = studentRepository.activateStudent(reference);
            return new MessageResp("Successful", "00", i + "student updated");
        }
    }
}
