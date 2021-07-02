package com.health.metrics.api;

import com.health.metrics.dto.UserHealthParamsDTO;
import com.health.metrics.entity.UserHealthParams;
import com.health.metrics.mapper.UserHealthParamsMapper;
import com.health.metrics.repository.UserHealthParamsRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 19 Mar, 2021 12:05 AM
 **/

@Slf4j
@RestController
@RequestMapping(value = "/userhealth")
public class QueryByForeignKeyController {

    @Autowired
    UserHealthParamsRepository userHealthParamsRepository;

    @GetMapping(value = "/user/{userId}/daily")
    public ResponseEntity<List<UserHealthParamsDTO>> getHealthMetricsDailyReport(
        @PathVariable(value = "userId", required = true) Long userId)
        throws Exception {
        List<UserHealthParams> userHealthParams = userHealthParamsRepository.findByUserId(userId);
        log.info("userHealthParams = {}", userHealthParams);
        List<UserHealthParamsDTO> userHealthParamsDTOS =
            UserHealthParamsMapper.INSTANCE.toUserHealthParamsDTOList(userHealthParams);
        return new ResponseEntity<>(userHealthParamsDTOS, HttpStatus.OK);
    }
}
