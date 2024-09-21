package ru.eqour.spring.lab2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String uid;
    private String operationUid;
    private String systemName;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;
}
