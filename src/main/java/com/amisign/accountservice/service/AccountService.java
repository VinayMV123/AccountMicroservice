package com.amisign.accountservice.service;

import com.amisign.accountservice.dto.UserDto;
import com.amisign.accountservice.model.UserDO;

public interface AccountService {
    UserDO createUserAccount(UserDto userDto);
}
