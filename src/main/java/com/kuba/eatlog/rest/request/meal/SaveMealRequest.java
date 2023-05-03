package com.kuba.eatlog.rest.request.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.dto.MealDetailsDto;
import com.kuba.eatlog.model.dto.MealDto;
import com.kuba.eatlog.model.dto.UserDto;
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

    @NotNull(message = "user is required")
    private UserEntity user;

    @JsonIgnore
    public static MealDto toDto(SaveMealRequest source){
        return MealDto.builder()
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(MealDetailsDto.from(source.getDetails()))
                .user(UserDto.from(source.getUser()))
                .build();
    }
}
