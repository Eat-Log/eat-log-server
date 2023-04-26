package com.kuba.eatlog.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.user.UserEntity;
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
    private MealDetails details;
    private Long userId;

    @JsonIgnore
    public static MealDto from(MealEntity source){
        return MealDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(source.getDetails())
                .userId(source.getUser().getId())
                .build();
    }
}
