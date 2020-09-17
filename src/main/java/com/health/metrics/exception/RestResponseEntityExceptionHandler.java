package com.health.metrics.exception;

import java.nio.file.AccessDeniedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 28 Sep, 2020 5:11 PM
 **/

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
        DeviceNotRegisteredException.class,
        UserNotRegisteredException.class,
        HealthMetricsNotFoundException.class
    })
    protected ResponseEntity<Object> handleNotFound(
        RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
            new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
        Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
            "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}