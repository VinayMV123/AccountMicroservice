/*
 * Copyright 2020 Impelsys India Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amisign.accountservice.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Stores request scoped data.
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class RequestContext {

    /**
     * Request ID.
     */
    private String requestId;


    /**
     * User ID.
     */
    private Long userId;

    /**
     * JWT token.
     */
    private String jwtToken;

    /**
     * Date time format
     */
    private String dateTimeFormat;

    /**
     * User type
     */
    private String userType;

    /**
     * @return True if header contains user id.
     */
    public Boolean hasPublicToken() {

        return Objects.nonNull(userId);
    }

    /**
     * @return True if header contains tenant id and user id.
     */
    public Boolean isValidUser() {

        return Objects.nonNull(userId);
    }

  /*  public Boolean isSuperAdminUser() {

        return StringUtils.isNotBlank(userType) && userType.equalsIgnoreCase(UserTypeCode.SUPER_ADMIN.code());
    }
*/
}
