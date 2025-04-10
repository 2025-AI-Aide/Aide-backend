package com.example.aide.service;

import com.example.aide.dto.UserDTO;
import com.example.aide.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public Boolean create(UserDTO userDTO) {
        Users user = Users.builder()
                .userId(userDTO.getUserId())
                .userPw(userDTO.getUserPw())
                .name(userDTO.getName()).build();

        if(user != null) {
            return true;
        }
        return false;
    }

}
