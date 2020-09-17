package com.health.metrics.exception;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 28 Sep, 2020 5:15 PM
 **/

public class UserNotRegisteredException extends RuntimeException {
    public UserNotRegisteredException() {
        super();
    }
    public UserNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNotRegisteredException(String message) {
        super(message);
    }
    public UserNotRegisteredException(Throwable cause) {
        super(cause);
    }
}
