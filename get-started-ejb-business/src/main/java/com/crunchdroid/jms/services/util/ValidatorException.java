package com.crunchdroid.jms.services.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
public class ValidatorException extends Exception {

    private Map<String, String> errors;

    public ValidatorException() {
        this.errors = new HashMap();
    }

    public ValidatorException(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

}
