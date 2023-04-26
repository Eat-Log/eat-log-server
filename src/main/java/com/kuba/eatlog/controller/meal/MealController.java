package com.kuba.eatlog.controller.meal;

import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.model.user.UserDto;
import com.kuba.eatlog.rest.request.SaveMealRequest;
import com.kuba.eatlog.rest.response.MealResponse;
import com.kuba.eatlog.rest.response.MealsResponse;
import com.kuba.eatlog.service.MealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kuba.eatlog.controller.ApiConstraints.MEAL;

@RestController
@RequestMapping(MEAL)
@RequiredArgsConstructor
public class MealController {

    public final static String SAVE_MEAL = "/save";
    public final static String FIND_ALL_MEALS = "/all";

    private final MealService mealService;

    @GetMapping(FIND_ALL_MEALS)
    public ResponseEntity<MealsResponse> findAllMeals(UserDto user){
        return new ResponseEntity<>(
                MealsResponse.from(mealService.findAllMealsForSpecificUserId(user.getId())),
                HttpStatus.OK
        );
    }

    @PostMapping(SAVE_MEAL)
    public ResponseEntity<MealResponse> saveMeal(
            @RequestBody @Valid SaveMealRequest meal){
        return new ResponseEntity<>(
                MealResponse.from(mealService.saveMeal(SaveMealRequest.toDto(meal))),
                HttpStatus.CREATED
        );
    }

}
