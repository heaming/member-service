package com.kafka.memeberservice.service;

import com.kafka.memeberservice.entity.UserEntity;
import com.kafka.memeberservice.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity registerUser(String loginId, String userName) {
        var user = new UserEntity(loginId, userName);
        return userRepository.save(user);
    }

    public UserEntity modifyUser(Long userId, String userName) {
        var user = userRepository.findById(userId).orElseThrow();
        user.userName = userName;

        return userRepository.save(user);
    }

    public UserEntity getUser(String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow();
    }

}
