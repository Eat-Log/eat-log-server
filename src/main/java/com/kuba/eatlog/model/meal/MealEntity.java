package com.kuba.eatlog.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meals")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalTime time;
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

    @JsonIgnore
    public static MealEntity toNewEntity(MealDto source){
        return MealEntity.builder()
                .title(source.getTitle())
                .time(LocalTime.parse(source.getTitle()))
                .date(LocalDate.parse(source.getTitle()))
                .details(source.getDetails())
                .user(source.getUser())
                .build();

    }
}
