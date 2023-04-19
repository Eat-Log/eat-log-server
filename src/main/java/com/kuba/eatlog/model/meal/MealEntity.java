package com.kuba.eatlog.model.meal;

import com.kuba.eatlog.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "meal")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "You have to provide title.")
    private String title;

    @NotEmpty(message = "You have to provide time of the meal")
    private LocalTime time;

    @NotEmpty(message = "You have to provide date for the meal")
    private LocalDate date;

    @OneToOne(
            mappedBy = "meal",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "meal_details_id")
    private MealDetails details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
