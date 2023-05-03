package com.kuba.eatlog.service.user;

import com.kuba.eatlog.model.dto.UserDto;
import com.kuba.eatlog.repository.UserRepository;
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
