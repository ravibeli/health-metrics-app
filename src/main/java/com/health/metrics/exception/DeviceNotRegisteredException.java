package com.health.metrics.exception;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 28 Sep, 2020 5:15 PM
 **/

public class DeviceNotRegisteredException extends RuntimeException {
    public DeviceNotRegisteredException() {
        super();
    }
    public DeviceNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
    public DeviceNotRegisteredException(String message) {
        super(message);
    }
    public DeviceNotRegisteredException(Throwable cause) {
        super(cause);
    }
}
