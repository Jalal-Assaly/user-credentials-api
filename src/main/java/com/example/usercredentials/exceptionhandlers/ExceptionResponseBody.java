package com.example.usercredentials.exceptionhandlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponseBody {
    @JsonProperty("timestamp")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTime;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String errorMessage;

    public ExceptionResponseBody(HttpStatusCode status, RuntimeException exception) {
        this.dateTime = LocalDateTime.now();
        this.status = status.value();
        this.errorMessage = exception.getMessage();
    }
}
