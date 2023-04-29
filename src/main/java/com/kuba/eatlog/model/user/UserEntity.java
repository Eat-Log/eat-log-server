package com.kuba.eatlog.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.meal.MealEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signed_in_user_name")
    private String signedInUserName;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<MealEntity> meals;

    @JsonIgnore
    public static UserEntity toNewEntity(UserDto source){
        return UserEntity.builder()
                .id(source.getId())
                .signedInUserName(source.getSignedInUserName())
                .build();
    }
}
