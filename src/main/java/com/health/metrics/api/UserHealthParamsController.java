package com.health.metrics.api;

import com.health.metrics.dto.AggregationUserHealthParamsDTO;
import com.health.metrics.dto.UserHealthParamsDTO;
import com.health.metrics.entity.UserHealthParams;
import com.health.metrics.mapper.UserHealthParamsMapper;
import com.health.metrics.service.UserHealthParamsService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 5:47 PM
 **/

@Slf4j
@RestController
@RequestMapping(value = "/health_metrics")
public class UserHealthParamsController {

    @Autowired
    UserHealthParamsService userHealthParamsService;

    /**
     * Demonstration of RequestParam using mobileNumber
     * Example: http://localhost:8080/health_metrics/aggregation?mobileNumber=1000000000
     *
     * @param mobileNumber
     * @return
     */
    @GetMapping(value = "/aggregation")
    @RequestMapping(value = "/{mobileNumber}",params = {"mobileNumber"})
    public ResponseEntity getHeathMetricsAggregationByMobileNumber(
        @RequestParam("mobileNumber") long mobileNumber) {

        log.info("MobileNumber from RequestParam = {}", mobileNumber);
        AggregationUserHealthParamsDTO aggregationUserHealthParamsDTO = null;
        try{
            aggregationUserHealthParamsDTO = userHealthParamsService.aggregationOfUserHealthMetrics(mobileNumber, null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (aggregationUserHealthParamsDTO != null) {
            return new ResponseEntity<>(aggregationUserHealthParamsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserHealthParamsDTO>> getAllUserHealthParams() {
        List<UserHealthParamsDTO> userHealthParamsDTOList = userHealthParamsService.getAllUserHealthParams();
        return new ResponseEntity<>(userHealthParamsDTOList, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserHealthParamsDTO> createUserHealthParams(@RequestBody UserHealthParamsDTO userHealthParamsDTO) {
        log.info("In DeviceController.createUser({})", userHealthParamsDTO);
        UserHealthParams userHealthParams = userHealthParamsService.createUserHealthParams(userHealthParamsDTO);
        UserHealthParamsDTO healthParamsDTO =  Mappers.getMapper(UserHealthParamsMapper.class).toUserHealthParamsDTO(userHealthParams);
        if (healthParamsDTO != null) {
            return new ResponseEntity<>(healthParamsDTO, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}
