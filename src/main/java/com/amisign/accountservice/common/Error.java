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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * <h1>Error</h1>
 * Represents API errors.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {

    private static final long serialVersionUID = -3464790953035483456L;

    private String code;
    private String target;
    private String message;
    private List<Error> details;

    public Error() {

    }

    public Error(String code, String target, String message) {
        super();
        this.code = code;
        this.target = target;
        this.message = message;
    }

    public Error(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "<Error CODE: " + getCode() + ", MESSAGE: " + getMessage() + ", DETAILS: " + getDetails() + ">";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        Error otherError = (Error) other;

        return Objects.equals(code, otherError.code)
                && Objects.equals(target, otherError.target)
                && Objects.equals(message, otherError.message)
                && Objects.deepEquals(details, otherError.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, target, message, details);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Error> getDetails() {
        return details;
    }

    public void setDetails(List<Error> details) {
        this.details = details;
    }

}
