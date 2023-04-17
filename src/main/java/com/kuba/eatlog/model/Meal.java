package com.kuba.eatlog.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("meal_id")
    private Long id;

    @Name("meal_title")
    private String title;

    @OneToOne
    @Name("meal_description")
    private Description description;

}
