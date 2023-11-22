package com.searce.boilerplates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends Printable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name", nullable = true, length = 300)
    @JsonProperty("name")
    private String name;

    @JsonProperty("salary")
    @Column(name = "salary", nullable = true)
    int salary;
    @JsonProperty("mobile")
    @Column(name = "mobile")
    private String mobile;
    @JsonProperty("gender")
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonProperty("dob")
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

//    @Transient
//    private int age;
}
