package com.example.aide.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
//    private Long id;
    private String userId;
    private String userPw;
    private String name;
}
