package com.kuba.eatlog.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.meal.MealDto;
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
    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Time is required")
    private LocalTime time;

    @NotNull(message = "Date is required")
    private LocalDate date;

    private MealDetails details;

    @JsonIgnore
    public static MealDto toDto(UpdateMealRequest source){
        return MealDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(source.getDetails())
                .build();
    }
}
