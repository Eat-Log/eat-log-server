package com.kuba.eatlog.service.user;

import com.kuba.eatlog.model.user.UserDto;
import com.kuba.eatlog.repository.UserRepository;
import com.kuba.eatlog.rest.request.user.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> UserDto.from(userEntity))
                .collect(Collectors.toList());
    }
}
