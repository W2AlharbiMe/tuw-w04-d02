package com.example.week04d2homework.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "the name field is required.")
    @Size(min = 5, message = "Length more than 4")
    @Column(columnDefinition = "VARCHAR(60) NOT NULL")
    private String name;


    @NotEmpty(message = "the username field is required.")
    @Size(min = 5, message = "Length more than 4")
    @Column(columnDefinition = "VARCHAR(60) NOT NULL UNIQUE")
    private String username;

    @NotEmpty(message = "the password field is required.")
    @Column(columnDefinition = "VARCHAR(60) NOT NULL")
    private String password;

    @NotEmpty(message = "the email field is required.")
    @Email(message = "invalid email.")
    @Column(columnDefinition = "VARCHAR(120) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "the role field is required.")
    @Pattern(message = "the role can only be 'user' or 'admin'.", regexp = "(?i)\\b(user)\\b?|(?i)\\b(admin)\\b")
    @Column(columnDefinition = "VARCHAR(5) NOT NULL")
    private String role;


    @NotNull(message = "the age field is required.")
    @Positive(message = "the age field can only be positive.")
    @Column(columnDefinition = "INT(110) NOT NULL")
    private Integer age;
}
