package com.kloudvista.studentmgtsys.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MessageResp {
    private String message;
    private String code;
    private Object object;

    public MessageResp(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
