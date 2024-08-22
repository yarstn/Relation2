package com.example.school.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username cannot be null or empty")
    @Size(min = 5, message = "Username must be longer than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;

    @NotNull(message = "age cannot be null or empty")
    @Column(columnDefinition = "int not null ")
    private int age;

    @NotEmpty(message = "email cannot be null or empty")
    @Email
    private String email;
    @NotNull(message = "salary cannot be null or empty")
    @Column(columnDefinition = "int not null ")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    //NO DUPLICATE

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> course;


}
