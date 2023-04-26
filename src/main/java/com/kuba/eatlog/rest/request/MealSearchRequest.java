package com.kuba.eatlog.repository;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealSearchRequest {
    private String title;
    private LocalTime time;
    private LocalDate date;
}
