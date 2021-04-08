

package com.amisign.accountservice.common;

import com.amisign.accountservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Validator for account related APIs (v1).
 */

@Component
public class Validator {

    private MessageByLocale messageByLocale;

    @Autowired
    public Validator(final MessageByLocale messageByLocale) {
        this.messageByLocale = messageByLocale;

    }

    /**
     * Validate user request.
     *
     * @return errors if userDTO is not valid
     */
    public List<ErrorData> validateTenantRequest(final UserDto userDto) {
        final List<ErrorData> errors = new ArrayList<>();


        final Boolean isUserDTO = Objects.nonNull(userDto);
        Predicate<Object> nullOrEmptyPredicate = ObjectUtils::isEmpty;

        Optional.ofNullable(validateFieldForInvalidArgument(() -> userDto, nullOrEmptyPredicate, Constants.ERROR_MESSAGES.INVALID_ARGUMENT))
                .ifPresent(errors::add);

        if (!isUserDTO) {
            return errors;
        }

        Optional.ofNullable(validateFieldForInvalidArgument(userDto::getUserName, nullOrEmptyPredicate, Constants.ERROR_MESSAGES.INVALID_ARGUMENT))
                .ifPresent(errors::add);

        Optional.ofNullable(validateFieldForInvalidArgument(userDto::getPassword, nullOrEmptyPredicate, Constants.ERROR_MESSAGES.INVALID_ARGUMENT))
                .ifPresent(errors::add);

        Optional.ofNullable(validateFieldForInvalidArgument(userDto::getToken, nullOrEmptyPredicate, Constants.ERROR_MESSAGES.INVALID_ARGUMENT))
                .ifPresent(errors::add);


        return errors;
    }

    public final <T> ErrorData validateFieldForInvalidArgument(final Supplier<T> supplier,
                                                               final Predicate<T> predicate,
                                                               final String fieldName) {
        Boolean isValid = predicate.test(supplier.get());
        ErrorData errorData = Optional.of(isValid)
                .filter(x -> x)
                .map(x -> {
                    final String requestBodyField = messageByLocale.getMessage(fieldName);
                    final String[] errorArgs = {requestBodyField};

                    return new ErrorData.Builder()
                            .code(ErrorCode.INVALID_ARGUMENT.name())
                            .target(requestBodyField)
                            .message(messageByLocale.getMessage(Constants.ERROR_MESSAGES.INVALID_ARGUMENT, errorArgs))
                            .build();
                })
                .orElse(null);

        return errorData;
    }
}
