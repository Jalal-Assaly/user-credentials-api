package com.example.usercredentials.models;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "User ID cannot be blank")
    @Size(min = 1, max = 1000000, message = "User ID does not meet size requirements")
//    @Pattern(regexp = "^\\d{1,6}$", message = "User ID is in an unrecognized format")
    private String id;

    @NotBlank(message = "SSN cannot be blank")
    @Pattern(regexp = "^\\d{14}$")
    private String ssn;

    @NotBlank(message = "First Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Given Email address has an unsuitable format")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).+$",
            message = "Password must include at least one number, one capital letter and one symbol")
    @Size(min = 7, message = "Password must include at least 7 characters")
    private String password;
}
