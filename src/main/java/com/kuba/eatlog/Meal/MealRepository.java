package com.kuba.eatlog.Meal;

import com.kuba.eatlog.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
