package com.kloudvista.studentmgtsys.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reference;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private boolean status;
    private String type;
}
