package com.kafka.memeberservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String loginId;

    public String userName;

    public UserEntity(String loginId, String userName) {
        this.loginId = loginId;
        this.userName = userName;
    }
}
