package com.amisign.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userName;

    private String password;

    private String token;
}
