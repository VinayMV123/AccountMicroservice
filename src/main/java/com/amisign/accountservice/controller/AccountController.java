package com.amisign.accountservice.controller;

import com.amisign.accountservice.common.*;
import com.amisign.accountservice.dto.UserDto;
import com.amisign.accountservice.model.UserDO;
import com.amisign.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {

    private RequestContext requestContext;
    private MessageByLocale messageByLocale;
    private Validator validator;
    private AccountService accountService;

    @Autowired
    public AccountController(
            final RequestContext requestContext,
            final MessageByLocale messageByLocale,
            final Validator validator,
            final AccountService accountService
    ) {
        this.requestContext = requestContext;
        this.messageByLocale = messageByLocale;
        this.validator = validator;
        this.accountService = accountService;
    }

    /**
     * API to on board a user.
     *
     * @return new user
     */
    @PostMapping()
    public ResponseEntity<ApiResponse> tenantSignUpStep1(@RequestBody final UserDto userDto) {

       Optional.of(Objects.nonNull(requestContext.getUserId()) && requestContext.isValidUser())
                .filter(x -> x)
                .orElseThrow(() -> new AccessDeniedException(messageByLocale.getMessage(Constants.ERROR_MESSAGES.ACCESS_DENIED)));

        final List<ErrorData> errors = validator.validateTenantRequest(userDto);

        // Throw exception if file is not there
        Optional.of(CollectionUtils.isEmpty(errors))
                .filter(x -> x)
                .orElseThrow(() -> new BadRequestException(messageByLocale.getMessage("error-message.bad-request"), errors));

         accountService.createUserAccount(userDto);


        final ApiResponse<Map> apiResponse = ApiResponse.<Map>builder()
                .status(HttpStatus.OK.value())
                .data(Collections.singletonMap("message", "account created"))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

}
