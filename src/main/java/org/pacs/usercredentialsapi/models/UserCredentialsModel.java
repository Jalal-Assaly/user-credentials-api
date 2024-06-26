package org.pacs.usercredentialsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCredentialsModel {

    @NotBlank(message = "ID cannot be blank")
    @Size(min = 1, max = 1000000, message = "ID does not meet size requirements")
    @JsonProperty("ID")
    private String id;

    @NotBlank(message = "SSN cannot be blank")
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$", message = "SSN does not follow the standard format")
    @JsonProperty("SSN")
    private String ssn;

    @NotBlank(message = "First Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must include letters only")
    @JsonProperty("FN")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must include letters only")
    @JsonProperty("LN")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Given Email address has an unsuitable format")
    @JsonProperty("EM")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @JsonProperty("PW")
    private String password;
}
