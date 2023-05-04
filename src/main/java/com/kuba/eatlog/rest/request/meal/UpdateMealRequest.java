package com.kuba.eatlog.rest.request.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.dto.MealDetailsDto;
import com.kuba.eatlog.model.dto.MealDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMealRequest {

    /*TODO in case something doesnt work maybe need to add null
       validation here for fields: title, time, date. */

    private String title;

    private LocalTime time;

    private LocalDate date;

    private MealDetailsDto details;


    @JsonIgnore
    public static MealDto toDto(UpdateMealRequest source){
        return MealDto.builder()
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(source.getDetails())
                .build();
    }
}
