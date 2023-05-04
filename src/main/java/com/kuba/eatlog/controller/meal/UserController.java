package com.kuba.eatlog.controller.meal;

import com.kuba.eatlog.rest.response.user.UsersResponse;
import com.kuba.eatlog.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kuba.eatlog.controller.ApiConstraints.USER;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    public static final String ALL = "/all";

    private final UserService userService;

    @GetMapping(ALL)
    public ResponseEntity<UsersResponse> getAllUsers(){
        return new ResponseEntity<>(
                UsersResponse.from(userService.getAllUsers()),
                HttpStatus.OK
        );
    }
}
