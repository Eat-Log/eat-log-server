package com.kuba.eatlog.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.dto.MealDetailsDto;
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

    @JsonIgnore
    public static MealDetails toNewEntity(MealDetailsDto source){
        return MealDetails.builder()
                .id(source.getId())
                .details(source.getDetails())
                .build();
    }

}
