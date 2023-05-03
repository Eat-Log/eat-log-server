package com.kuba.eatlog.factory;

import com.kuba.eatlog.model.dto.MealDetailsDto;
import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.dto.MealDto;
import com.kuba.eatlog.model.meal.MealEntity;
import com.kuba.eatlog.model.user.UserEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class MealFactory {


    public static MealEntity.MealEntityBuilder dummyMeal(){
        return MealEntity.builder()
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-27"))
                .details(dummyMealDetails().build())
                .user(new UserEntity(1L, "Kuba", null));
    }

    public static MealDto.MealDtoBuilder dummyMealDto(){
        return MealDto.builder()
                .id(1L)
                .title("Breakfast")
                .time(LocalTime.parse("09:00"))
                .date(LocalDate.parse("2023-04-27"))
                .details(dummyMealDetailsDto().build())
                .user(new UserDto(1L, "Kuba"));
    }

    private static MealDetails.MealDetailsBuilder dummyMealDetails(){
        return MealDetails.builder()
                .details("3 eggs");
    }

    private static MealDetailsDto.MealDetailsDtoBuilder dummyMealDetailsDto(){
        return MealDetailsDto.builder()
                .details("3 eggs");
    }
}
