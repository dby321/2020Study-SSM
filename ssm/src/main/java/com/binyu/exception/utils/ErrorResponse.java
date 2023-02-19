package com.binyu.exception.utils;

import com.binyu.exception.constants.ApplicationConstants;

import java.util.List;

public class ErrorResponse {
    private ApplicationConstants serverError;
    private List<String> details;
    public ErrorResponse(ApplicationConstants serverError, List<String> details) {
        this.serverError=serverError;
        this.details=details;
    }
}
