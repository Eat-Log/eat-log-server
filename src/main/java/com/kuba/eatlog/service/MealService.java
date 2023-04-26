package com.kuba.eatlog.service;

import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.rest.request.MealSearchRequest;

import java.util.List;

public interface MealService {

    MealDto findById(Long mealId);
    List<MealDto> findAllMealsForSpecificUserId(Long userId);

    List<MealDto> findByCriteriaForSpecificUserId(MealSearchRequest criteria);
    MealDto saveMeal(MealDto mealDto);
    MealDto updateMeal(MealDto mealDto);
    void deleteById(Long mealId);
}
