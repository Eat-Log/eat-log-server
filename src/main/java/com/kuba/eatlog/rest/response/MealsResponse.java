package com.kuba.eatlog.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealsResponse {

    @Builder.Default
    private List<MealDto> meals = new ArrayList<>();

    @JsonIgnore
    public static MealsResponse from(List<MealDto> source){
        return MealsResponse.builder()
                .meals(source)
                .build();
    }
}
