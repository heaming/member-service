package com.kafka.memeberservice.controller;

import com.kafka.memeberservice.dto.ModifyUserDto;
import com.kafka.memeberservice.dto.RegisterUserDto;
import com.kafka.memeberservice.entity.UserEntity;
import com.kafka.memeberservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public UserEntity registerUser(@RequestBody RegisterUserDto request) {
        return userService.registerUser(request.loginId, request.userName);
    }

    @PutMapping("/users/{userId}")
    public UserEntity modifyUser(@PathVariable Long userId,
                                 @RequestBody ModifyUserDto request) {
        return userService.modifyUser(userId, request.userName);
    }

    @PostMapping("/{loginId}")
    public UserEntity login(@PathVariable String loginId) {
        return userService.getUser(loginId);
    }

}
