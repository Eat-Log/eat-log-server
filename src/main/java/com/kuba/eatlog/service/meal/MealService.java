package com.kuba.eatlog.service.meal;

import com.kuba.eatlog.model.dto.MealDto;
import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.rest.request.meal.MealSearchRequest;

import java.util.List;

public interface MealService {

    MealDto findById(Long mealId);

    List<MealDto> findAllMealsForSpecificUser(UserDto userDto);


    List<MealDto> findByCriteriaForSpecificUserId(MealSearchRequest criteria);

    MealDto saveMeal(MealDto mealDto);

//    MealDto updateMeal(MealDto mealDto);

    void deleteById(Long mealId);

}
