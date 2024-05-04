package com.kloudvista.studentmgtsys.repository;

import com.kloudvista.studentmgtsys.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface StudentRepository extends JpaRepository<Student, Long > {
    Student findByReference(String reference);
    Student findByEmail(String emailAddress);

    @Modifying
    @Query("delete Student s where s.reference = ?1")
    int deleteStudent(String reference);

    @Modifying
    @Query("delete from Student s where s.reference =: reference")
    int deleteStudent2(@Param("reference") String reference);

    @Modifying
    @Query("update Student s set s.firstName = ?1, " +
            "s.lastName = ?2 , s.phoneNumber = ?3 , dateUpdated = ?4 " +
            "where s.reference = ?5")
    int updateStudent(String firstName, String lastName, String phoneNumber, LocalDateTime dateUpdated, String reference);

    @Modifying
    @Query("update Student s set s.status = true where s.reference = ?1")
    int activateStudent(String reference);

}
