package com.kuba.eatlog.repository;

import com.kuba.eatlog.model.meal.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long>, JpaSpecificationExecutor<MealEntity> {

}
