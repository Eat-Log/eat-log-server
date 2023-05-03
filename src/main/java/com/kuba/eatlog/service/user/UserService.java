package com.kuba.eatlog.service.user;

import com.kuba.eatlog.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
