package com.kuba.eatlog.service.meal;

import com.kuba.eatlog.exception.exceptions.EntityNotFoundException;
import com.kuba.eatlog.model.meal.MealDetails;
import com.kuba.eatlog.model.dto.MealDetailsDto;
import com.kuba.eatlog.model.dto.MealDto;
import com.kuba.eatlog.model.meal.MealEntity;
import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.repository.MealRepository;
import com.kuba.eatlog.rest.request.meal.MealSearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Override
    public MealDto saveMeal(MealDto mealDto) {
        MealEntity meal = MealEntity.toNewEntity(mealDto);
        MealDetailsDto details = mealDto.getDetails();
        meal.setDetails(MealDetails.toNewEntity(details));
        return MealDto.from(repository.save(meal));
    }

    @Override
    public List<MealDto> findAllMealsForSpecificUser(UserDto userDto) {
        List<MealDto> meals = repository.findAll()
                .stream()
                .map(mealEntity -> MealDto.from(mealEntity, userDto))
                .toList();
        log.info(meals.toString());

        return meals;
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
    public MealDto updateMeal(Long mealId, MealDto mealDto) {

        var mealToUpdate = repository.findById(mealId)
                .orElseThrow(()->new EntityNotFoundException(MealEntity.class, mealDto.getId()));

        mealToUpdate.setTitle(mealDto.getTitle());
        mealToUpdate.setTime(mealDto.getTime());
        mealToUpdate.setDate(mealDto.getDate());
        mealToUpdate.setDetails(MealDetails.toNewEntity(mealDto.getDetails()));


        return MealDto.from(repository.save(mealToUpdate));
    }

    @Override
    public void deleteById(Long mealId) {
        MealEntity meal = repository.findById(mealId)
                .orElseThrow(() -> new EntityNotFoundException(MealEntity.class, mealId));
        repository.delete(meal);
    }

}
