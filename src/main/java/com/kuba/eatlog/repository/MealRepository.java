package com.kuba.eatlog.repository;

import com.kuba.eatlog.model.meal.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long>, JpaSpecificationExecutor<MealEntity> {

    @Query("""
        SELECT m    \s
        FROM MealEntity m
        ORDER BY m.time ASC     \s
    """
    )
    List<MealEntity> findAllForSignedInUser(
            @Param("id") Long id
    );
}
