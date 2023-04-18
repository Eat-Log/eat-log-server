package com.kuba.eatlog.repository;

import com.kuba.eatlog.model.Meal;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query("""
        SELECT m    \s
        FROM Meal m
        JOIN User u
        ON m.id = u.id
        WHERE u.email = :email
        ORDER BY m.time ASC     \s
    """
    )
    List<Meal> findAllForSignedInUser(
            @Param("email") String email
    );

    @Query("""
        SELECT m    \s
        FROM Meal m
        WHERE m.id = :id
        ORDER BY m.time ASC     \s
    """
    )
    Optional<Meal> findMealByIdForSignedInUser(
            @Param("id") Long id
    );
}
