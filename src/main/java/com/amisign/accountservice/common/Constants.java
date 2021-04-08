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

/**
 * <h1>Constants</h1>
 * Declaration of application constants.
 */
public final class Constants {


    private Constants() {
    }

    /**
     * Error messages
     */
    public interface ERROR_MESSAGES {

        String BAD_REQUEST_MESSAGE = "error-message.bad-request";
        String ACCESS_DENIED = "error-message.access-denied";
        String RESOURCE_NOT_FOUND = "error-message.resources-not-found";
        String NULL_VALUE = "error-message.null-value";
        String INVALID_ARGUMENT = "error-message.invalid-argument";
    }

    public interface FIELDS {
        String REQUEST_BODY = "field.request.body";
    }

}
