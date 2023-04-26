package com.kuba.eatlog.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.model.user.UserDto;
import com.kuba.eatlog.model.user.UserEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveMealRequest {

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "time is required")
    private LocalTime time;

    @NotNull(message = "date is required")
    private LocalDate date;

    private MealDetails details;

    @NotNull(message = "user_id is required")
    private UserEntity user;

    @JsonIgnore
    public static MealDto toDto(SaveMealRequest source){
        return MealDto.builder()
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(source.getDetails())
                .userId(source.user.getId())
                .build();
    }
}
