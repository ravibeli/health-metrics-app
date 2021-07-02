package com.health.metrics.api;

import com.health.metrics.dto.AggregationUserHealthParamsDTO;
import com.health.metrics.enums.ReportEnum;
import com.health.metrics.service.UserHealthParamsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 17 Sep, 2020 3:25 PM
 **/

@Slf4j
@RestController
@RequestMapping(value = "/health_report")
public class HealthReportController {

    @Autowired
    UserHealthParamsService userHealthParamsService;

    /**
     * Demonstration of PathVariable using userId
     * Example: http://localhost:8080/health_report/user/1/daily
     * @param userId the userId
     * @return the aggregated user health parameters
     */
    @GetMapping(value = "/user/{userId}/daily")
    public ResponseEntity<AggregationUserHealthParamsDTO> getHealthMetricsDailyReport(@PathVariable(value = "userId", required = true) long userId)
        throws Exception {
        AggregationUserHealthParamsDTO aggregationUserHealthParamsDTO = userHealthParamsService.getHealthMetricsDailyReportByUserId(userId);
        return new ResponseEntity<>(aggregationUserHealthParamsDTO, HttpStatus.OK);
    }

    /**
     * Demonstration of PathVariable using mobileNumber
     * Example: http://localhost:8080/health_report/mobile/1000000000/daily
     * @param mobileNumber
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/mobile/{mobileNumber}/daily")
    public ResponseEntity<AggregationUserHealthParamsDTO> getHealthMetricsByMobileNumberDailyReport(@PathVariable(value = "mobileNumber", required = true) long mobileNumber)
        throws Exception {
        AggregationUserHealthParamsDTO aggregationUserHealthParamsDTO = userHealthParamsService.aggregationOfUserHealthMetrics(mobileNumber, ReportEnum.DAILY);
        return new ResponseEntity<>(aggregationUserHealthParamsDTO, HttpStatus.OK);
    }

    /**
     * Demonstration of PathVariable using mobileNumber
     * Example: http://localhost:8080/health_report/mobile/1000000000/weekly
     * @param mobileNumber
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/mobile/{mobileNumber}/weekly")
    public ResponseEntity<AggregationUserHealthParamsDTO> getHealthMetricsByMobileNumberWeeklyReport(@PathVariable(value = "mobileNumber", required = true) long mobileNumber)
        throws Exception {
        AggregationUserHealthParamsDTO aggregationUserHealthParamsDTO = userHealthParamsService.aggregationOfUserHealthMetrics(mobileNumber, ReportEnum.WEEKLY);
        return new ResponseEntity<>(aggregationUserHealthParamsDTO, HttpStatus.OK);
    }
}
