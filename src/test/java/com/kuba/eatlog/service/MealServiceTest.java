package com.kuba.eatlog.service;

import com.kuba.eatlog.factory.MealFactory;
import com.kuba.eatlog.model.dto.MealDto;
import com.kuba.eatlog.repository.MealRepository;
import com.kuba.eatlog.service.meal.MealServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

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
    void whenSaveMeal_thenReturnCorrectMealDto(){
        //given
        var mealDto = MealFactory.dummyMealDto().build();
        var expectedMeal = MealFactory.dummyMeal().build();

        when(mealRepository.save(any())).thenReturn(expectedMeal);

        //when
        MealDto result = mealService.saveMeal(mealDto);

        //then
        assertNotNull(result);
        assertEquals(expectedMeal.getId(), result.getId());
        assertEquals(expectedMeal.getTime(), result.getTime());
        assertEquals(expectedMeal.getDate(), result.getDate());
        assertEquals(expectedMeal.getTitle(), result.getTitle());
    }

    //TODO whenSaveMeal_thenThrowException()

    @Test
    void whenFindById_thenReturnCorrectMeal(){
        //given
        var expectedMeal = MealFactory.dummyMeal().build();

        when(mealRepository.findById(expectedMeal.getId())).thenReturn(Optional.of(expectedMeal));

        //when
        MealDto result = mealService.findById(expectedMeal.getId());

        //then
        assertNotNull(result);
        assertEquals(result.getId(), expectedMeal.getId());
    }

    //TODO whenFinById_thenThrowException()
}
