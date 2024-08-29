package ru.semyak.studentapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.UniqueKey;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;

    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth,
                LocalDate.ofEpochDay(LocalDate.now().getYear())).getYears();
    }
}
