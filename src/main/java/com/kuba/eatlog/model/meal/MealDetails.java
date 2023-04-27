package com.kuba.eatlog.model.meal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal_details")
public class MealDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String details;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id")
    private MealEntity meal;
}
