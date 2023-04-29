package com.kuba.eatlog.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealDetailsDto {

    private Long id;

    private String details;

    @JsonIgnore
    public static MealDetailsDto from(MealDetails source){
        return MealDetailsDto.builder()
                .id(source.getId())
                .details(source.getDetails())
                .build();
    }
}
