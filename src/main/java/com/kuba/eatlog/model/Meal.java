package com.kuba.eatlog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal")
public class Meal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;

    private LocalDate date;

    private LocalTime time;

    @OneToOne(
            mappedBy = "meal",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "meal_details_id")
    private MealDetails details;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
