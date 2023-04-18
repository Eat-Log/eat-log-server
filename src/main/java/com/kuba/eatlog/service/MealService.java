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

    public Object updateMealById(Long id, Meal meal){
        return existsById(id) ? updateMeal(meal) : throwException();
    }

    private boolean existsById(Long id){
        return repository.existsById(id);
    }

    private Meal updateMeal(Meal meal){
         return Meal.builder()
                 .id(meal.getId())
                 .title(meal.getTitle())
                 .time(meal.getTime())
                 .date(meal.getDate())
                 .details(meal.getDetails())
                 .user(meal.getUser())
                 .build();
    }

    private Throwable throwException(){
        return new ResourceNotFoundException("Meal not found in database!");
    }
}
