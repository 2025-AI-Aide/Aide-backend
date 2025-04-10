package com.example.aide.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
//    private Long id;
    private String userId;
    private String userPw;
    private String name;
}
