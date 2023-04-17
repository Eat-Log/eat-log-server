package com.kuba.eatlog.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("ingredient_id")
    private Long id;

    @Name("ingredient_name")
    private String name;

    @Name("quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(
            name = "description_id",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Description mealDescriptions;
}
