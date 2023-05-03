package com.kuba.eatlog.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.user.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String signedInUserName;

    @JsonIgnore
    public static UserDto from(UserEntity source){
        return UserDto.builder()
                .id(source.getId())
                .signedInUserName(source.getSignedInUserName())
                .build();
    }

}
