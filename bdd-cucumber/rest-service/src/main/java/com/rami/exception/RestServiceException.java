package com.rami.exception;

public class RestServiceException extends RuntimeException {

    private String reason;

    public RestServiceException(final String reason) {
        this.reason=reason;
    }

    public String getReason() {
        return reason;
    }
}
