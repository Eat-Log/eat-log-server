package com.kuba.eatlog.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.dto.MealDto;
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
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private MealDetails details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @JsonIgnore
    public static MealEntity toNewEntity(MealDto source){
        return MealEntity.builder()
                .title(source.getTitle())
                .time(source.getTime())
                .date(source.getDate())
                .details(MealDetails.toNewEntity(source.getDetails()))
                .user(UserEntity.toNewEntity(source.getUser()))
                .build();

    }
}
