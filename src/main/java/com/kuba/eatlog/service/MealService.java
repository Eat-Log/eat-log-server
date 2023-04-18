package com.kuba.eatlog.service;

import com.kuba.eatlog.exception.ResourceNotFoundException;
import com.kuba.eatlog.model.Meal;
import com.kuba.eatlog.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository repository;

    public Meal createMeal(Meal meal) {
        return repository.save(meal);
    }

    public List<Meal> getAllMeals(String email){
        return repository.findAllForSignedInUser(email);
    }

    public Meal getMealById(Long id){
        return
                repository.findMealByIdForSignedInUser(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Meal not found in database!")
                        );
    }
}
