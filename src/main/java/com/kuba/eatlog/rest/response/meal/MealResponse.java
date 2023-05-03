package com.kuba.eatlog.rest.response.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.dto.MealDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse {

    private MealDto meal;

    @JsonIgnore
    public static MealResponse from(MealDto source){
        return MealResponse.builder()
                .meal(source)
                .build();
    }
}
