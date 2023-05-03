package com.kuba.eatlog.controller.meal;


import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.rest.request.meal.SaveMealRequest;
import com.kuba.eatlog.rest.response.meal.MealResponse;
import com.kuba.eatlog.rest.response.meal.MealsResponse;
import com.kuba.eatlog.service.meal.MealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.kuba.eatlog.controller.ApiConstraints.MEAL;

@RestController
@RequestMapping(MEAL)
@RequiredArgsConstructor
public class MealController {

    public final static String SAVE_MEAL = "/save";
    public final static String ALL_MEALS = "/all";

    private final MealService mealService;


    @GetMapping(ALL_MEALS)
    public ResponseEntity<MealsResponse> getALlMeals(@RequestBody UserDto userDto){
        return new ResponseEntity<>(
                MealsResponse.from(mealService.findAllMealsForSpecificUserId(userDto)),
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
