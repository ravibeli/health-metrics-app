package com.health.metrics.exception;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 28 Sep, 2020 5:16 PM
 **/

public class HealthMetricsNotFoundException extends RuntimeException {
    public HealthMetricsNotFoundException() {
        super();
    }
    public HealthMetricsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public HealthMetricsNotFoundException(String message) {
        super(message);
    }
    public HealthMetricsNotFoundException(Throwable cause) {
        super(cause);
    }
}
