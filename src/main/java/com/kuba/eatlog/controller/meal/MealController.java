package com.kuba.eatlog.controller.meal;


import com.kuba.eatlog.rest.request.SaveMealRequest;
import com.kuba.eatlog.rest.response.MealResponse;
import com.kuba.eatlog.service.MealService;
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

    private final MealService mealService;


    @PostMapping(SAVE_MEAL)
    public ResponseEntity<MealResponse> saveMeal(
            @RequestBody @Valid SaveMealRequest meal){
        return new ResponseEntity<>(
                MealResponse.from(mealService.saveMeal(SaveMealRequest.toDto(meal))),
                HttpStatus.CREATED
        );
    }

}
