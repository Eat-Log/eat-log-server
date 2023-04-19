package com.kuba.eatlog.service;

import com.kuba.eatlog.exception.exceptions.EntityNotFoundException;
import com.kuba.eatlog.model.meal.MealEntity;
import com.kuba.eatlog.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl {

    private final MealRepository repository;

    public MealEntity saveMeal(MealEntity meal) {
        return repository.save(meal);
    }

    public List<MealEntity> getAllMeals(String email){
        return repository.findAllForSignedInUser(email);
    }

    public MealEntity getMealById(Long id){
        return
                repository.findMealByIdForSignedInUser(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(getClass(), id)
                        );
    }

    private boolean existsById(Long id){
        return repository.existsById(id);
    }

    private MealEntity createMeal(MealEntity meal){
         return MealEntity.builder()
                 .title(meal.getTitle())
                 .time(meal.getTime())
                 .date(meal.getDate())
                 .details(meal.getDetails())
                 .user(meal.getUser())
                 .build();
    }

}
