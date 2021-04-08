package com.amisign.accountservice.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the structure of error data in api response.
 */
@Getter
@Setter
public final class ErrorData implements Serializable {

    /**
     * Error code.
     */
    private String code;

    /**
     * Error target.
     */
    private String target;

    /**
     * Error message.
     */
    private String message;

    /**
     * Nested errors.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorData> details;

    private ErrorData(final Builder builder) {
        this.code = builder.code;
        this.target = builder.target;
        this.message = builder.message;
        this.details = builder.details;
    }

    /**
     * Builder for {@link ErrorData}.
     */
    public static final class Builder {

        /**
         * Code value.
         */
        private String code;

        /**
         * Target value.
         */
        private String target;

        /**
         * Message value.
         */
        private String message;

        /**
         * Details value.
         */
        private List<ErrorData> details;

        /**
         * Set error code.
         *
         * @param codeValue value for code
         * @return builder
         */
        public Builder code(final String codeValue) {
            this.code = codeValue;

            return this;
        }

        /**
         * Set error target.
         *
         * @param targetValue value for target
         * @return builder
         */
        public Builder target(final String targetValue) {
            this.target = targetValue;

            return this;
        }

        /**
         * Set error message.
         *
         * @param messageValue value for message
         * @return builder
         */
        public Builder message(final String messageValue) {
            this.message = messageValue;

            return this;
        }

        /**
         * Set nested errors.
         *
         * @param detailsValue value for details
         * @return builder
         */
        public Builder details(final List<ErrorData> detailsValue) {
            this.details = detailsValue;

            return this;
        }

        /**
         * @return instance of {@link ErrorData}.
         */
        public ErrorData build() {
            return new ErrorData(this);
        }

    }

}
