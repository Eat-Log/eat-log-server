package com.kuba.eatlog.service;

import com.kuba.eatlog.model.meal.MealDto;

import java.util.List;

public interface MealService {

    MealDto findByIdForSpecificUserId(Long userId, Long mealId);
    List<MealDto> findAllMealsForSpecificUserId(Long userId);

    List<MealDto> findByCriteriaForSpecificUserId();
    MealDto saveMeal(MealDto mealDto);
    MealDto udpateMeal(MealDto mealDto);
    void deleteById(Long mealId);
}
