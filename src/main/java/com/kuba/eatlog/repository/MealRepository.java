package com.kuba.eatlog.repository;

import com.kuba.eatlog.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
