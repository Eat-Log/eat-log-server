package com.kuba.eatlog.service.user;

import com.kuba.eatlog.model.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
