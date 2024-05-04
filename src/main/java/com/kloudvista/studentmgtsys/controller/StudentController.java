package com.kloudvista.studentmgtsys.controller;

import com.kloudvista.studentmgtsys.domain.Student;
import com.kloudvista.studentmgtsys.dto.MessageResp;
import com.kloudvista.studentmgtsys.dto.NewStudent;
import com.kloudvista.studentmgtsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity newStudent(@RequestBody NewStudent newStudent) {
        String studentId = studentService.NewStudent(newStudent);
        return new ResponseEntity<>(studentId, HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by/{ref}")
    public ResponseEntity<Student> getStudentByRef(@PathVariable String ref) {
        Student student = studentService.findStudentByRef(ref);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get-all-student")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageResp> updateStudent(@RequestBody NewStudent newStudent){
        MessageResp student = studentService.updateStudent(newStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/activate-student/{reference}")
    public ResponseEntity<MessageResp> activateStudent(@PathVariable String reference){
        MessageResp messageResp = studentService.activateStudent(reference);
        return new ResponseEntity<>(messageResp, HttpStatus.OK);
    }

    @DeleteMapping("/ref")
    public ResponseEntity deleteStudent(@PathVariable String reference){
        int student = studentService.deleteStudent(reference);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
