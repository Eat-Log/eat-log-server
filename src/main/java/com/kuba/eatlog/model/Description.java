package com.kuba.eatlog.model;

import jakarta.annotation.Nullable;
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
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("description_id")
    private Long id;

    @Nullable
    @Name("description")
    private String description;

    @OneToMany
    @JoinColumn(name = "description_id")
    private Set<Ingredient> ingredients;

}
