package com.kuba.eatlog.factory;

import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.model.meal.MealEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class MealFactory {


    public static MealEntity.MealEntityBuilder dummyMeal(){
        return MealEntity.builder()
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-27"))
                .details(dummyMealDetails().build());
    }

    public static MealDto.MealDtoBuilder dummyMealDto(){
        return MealDto.builder()
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-27"))
                .details(dummyMealDetails().build());
    }

    private static MealDetails.MealDetailsBuilder dummyMealDetails(){
        return MealDetails.builder()
                .details("3 eggs");
    }
}
