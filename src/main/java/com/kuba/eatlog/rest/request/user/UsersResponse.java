package com.kuba.eatlog.rest.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuba.eatlog.model.user.UserDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponse {

    @Builder.Default
    private List<UserDto> users = new ArrayList<>();

    @JsonIgnore
    public static UsersResponse from(List<UserDto> source) {
        return UsersResponse.builder()
                .users(source)
                .build();
    }
}
