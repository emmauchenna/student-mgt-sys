package com.kloudvista.studentmgtsys.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class NewStudent {

    private String reference;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String type;
}
