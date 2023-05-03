package com.kuba.eatlog.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private Long id;
    private String title;
    private LocalTime time;
    private LocalDate date;
    private MealDetailsDto details;
    private UserDto user;

    @JsonIgnore
    public static MealDto from(MealEntity source){
        return MealDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(MealDetailsDto.from(source.getDetails()))
                .user(UserDto.from(source.getUser()))
                .build();
    }

    @JsonIgnore
    public static MealDto from(MealEntity source, UserDto userDto){
        return MealDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(MealDetailsDto.from(source.getDetails()))
                .user(userDto)
                .build();
    }

}
