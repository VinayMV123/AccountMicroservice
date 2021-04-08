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

import lombok.*;

import java.io.Serializable;

/**
 * This class represents the general response structure of the api.
 * @param <T> response data
 */
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public final class ApiResponse<T> implements Serializable {

    /**
     * HTTP status.
     */
    private Integer status;

    /**
     * Error data.
     */
    private ErrorData error;

    /**
     * Response data.
     */
    private T data;

}
