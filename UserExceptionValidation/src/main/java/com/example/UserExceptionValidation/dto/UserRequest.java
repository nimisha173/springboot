package com.example.UserExceptionValidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "name should not be null")
    private String name;
    @Email(message="email is in valid format")
    private String email;
    private String mobile;
    @Min(18)
    @Max(60)
    private int age;


}
