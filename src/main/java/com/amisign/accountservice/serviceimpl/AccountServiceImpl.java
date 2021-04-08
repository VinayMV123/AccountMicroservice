package com.amisign.accountservice.serviceimpl;

import com.amisign.accountservice.dto.UserDto;
import com.amisign.accountservice.model.UserDO;
import com.amisign.accountservice.repository.AccountRepository;
import com.amisign.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public UserDO createUserAccount(UserDto userDto) {

        final UserDO userDetails = UserDO.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .token(userDto.getToken())
                .build();
        return accountRepository.save(userDetails);


    }
}

