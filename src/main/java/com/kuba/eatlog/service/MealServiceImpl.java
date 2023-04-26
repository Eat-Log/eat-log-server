package com.kuba.eatlog.service;

import com.kuba.eatlog.exception.exceptions.EntityNotFoundException;
import com.kuba.eatlog.model.meal.MealDto;
import com.kuba.eatlog.model.meal.MealEntity;
import com.kuba.eatlog.repository.MealRepository;
import com.kuba.eatlog.rest.request.MealSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Override
    public MealDto saveMeal(MealDto mealDto) {
        return MealDto.from(repository.save(MealEntity.toNewEntity(mealDto)));
    }

    @Override
    public List<MealDto> findAllMealsForSpecificUserId(Long userId) {
        return repository.findAllForSignedInUser(userId)
                .stream()
                .map(x -> MealDto.from(x))
                .collect(Collectors.toList());
    }


    //TODO Implement criteria as you need later
    @Override
    public List<MealDto> findByCriteriaForSpecificUserId(MealSearchRequest criteria) {
        return null;
    }

    @Override
    public MealDto findById(Long mealId) {
        return MealDto.from(repository.findById(mealId)
                .orElseThrow(() -> new EntityNotFoundException(MealEntity.class, mealId)));
    }
    @Override
    public MealDto updateMeal(MealDto mealDto){
        return MealDto.from(repository.findById(mealDto.getId()).map(mealEntity -> {
            mealEntity.setTitle(mealDto.getTitle());
            mealEntity.setTime(mealDto.getTime());
            mealEntity.setDate(mealDto.getDate());
            mealEntity.setDetails(mealDto.getDetails());
            return mealEntity;
        }).orElseThrow(() -> new EntityNotFoundException(MealEntity.class, mealDto.getId())));
    }

    @Override
    public void deleteById(Long mealId) {
        MealEntity meal = repository.findById(mealId)
                .orElseThrow(() -> new EntityNotFoundException(MealEntity.class, mealId));
        repository.delete(meal);
    }

}
