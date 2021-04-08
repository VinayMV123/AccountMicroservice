/*
 * Copyright 2018 Impelsys India Pvt. Ltd.
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

import org.springframework.http.HttpStatus;

/**
 * <h1>ErrorCode</h1>
 * Custom errors and corresponding http status codes.
 */
public enum ErrorCode {
    OK(HttpStatus.OK),                                          // 200
    MULTI_STATUS(HttpStatus.MULTI_STATUS),                      // 207
    INVALID_ARGUMENT(HttpStatus.BAD_REQUEST),                   // 400
    BAD_REQUEST(HttpStatus.BAD_REQUEST),                        // 400
    INVALID_HEADER(HttpStatus.BAD_REQUEST),                     // 400
    MISSING_HEADER(HttpStatus.BAD_REQUEST),                     // 400
    NULL_VALUE(HttpStatus.BAD_REQUEST),                         // 400
    DUPLICATE(HttpStatus.BAD_REQUEST),                          // 400
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),                      // 401
    ACCESS_DENIED(HttpStatus.FORBIDDEN),                        // 403
    NOT_FOUND(HttpStatus.NOT_FOUND),                            // 404
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED),          // 405
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT),                // 408
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE),  // 415
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY),      // 422
    OVERLAPPING_DATE(HttpStatus.UNPROCESSABLE_ENTITY),          // 422
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),    // 500
    CONFLICT(HttpStatus.CONFLICT),                              // 409
    ALREADY_EXISTS(HttpStatus.CONFLICT);                        // 409

    private HttpStatus statusCode;

    private ErrorCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public Integer value() {
        return statusCode.value();
    }

    public HttpStatus statusCode() {
        return statusCode;
    }
}
