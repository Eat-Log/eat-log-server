package com.kuba.eatlog.service;

import com.kuba.eatlog.factory.MealFactory;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.model.meal.MealEntity;
import com.kuba.eatlog.repository.MealRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MealServiceTest {

    @Mock
    private MealRepository mealRepository;

    @InjectMocks
    private MealServiceImpl mealService;

    @Test
    void whenCorrectMealSaved_thenReturnCorrectMeal(){
        //given
        var mealDto = MealFactory.dummyMealDto().build();
        var expectedMeal = MealFactory.dummyMeal().build();

        when(mealRepository.save(any())).thenReturn(expectedMeal);

        //when
        MealDto result = mealService.saveMeal(mealDto);

        //then
        assertNotNull(result);
        assertEquals(expectedMeal.getId(), result.getId());
    }
}
