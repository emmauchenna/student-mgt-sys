package com.kloudvista.studentmgtsys.service;

import com.kloudvista.studentmgtsys.controller.StudentController;
import com.kloudvista.studentmgtsys.domain.Student;
import com.kloudvista.studentmgtsys.dto.MessageResp;
import com.kloudvista.studentmgtsys.dto.NewStudent;

import java.util.List;

public interface StudentService {
    String NewStudent(NewStudent student);

    Student findStudentByRef(String ref);

    List<Student> getAllStudent();

    MessageResp updateStudent(NewStudent newStudent);

    int  deleteStudent(String reference);

    MessageResp activateStudent(String reference);
}
