package com.health.metrics.service;

import com.health.metrics.dto.AggregationUserHealthParamsDTO;
import com.health.metrics.dto.UserHealthParamsDTO;
import com.health.metrics.entity.MobileDevice;
import com.health.metrics.entity.User;
import com.health.metrics.entity.UserHealthParams;
import com.health.metrics.enums.ReportEnum;
import com.health.metrics.exception.DeviceNotRegisteredException;
import com.health.metrics.exception.UserNotRegisteredException;
import com.health.metrics.mapper.UserHealthParamsMapper;
import com.health.metrics.repository.MobileRegistrationRepository;
import com.health.metrics.repository.UserHealthParamsRepository;
import com.health.metrics.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:19 PM
 **/

@Slf4j
@Service
public class UserHealthParamsService {

    @Autowired
    UserHealthParamsRepository userHealthParamsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MobileRegistrationRepository mobileDeviceRepository;

    public UserHealthParams createUserHealthParams(UserHealthParamsDTO userHealthParamsDTO){
        MobileDevice mobileDevice = mobileDeviceRepository.findByMobileNumber(userHealthParamsDTO.getMobileNumber());
        User user = userRepository.findByEmailId(mobileDevice.getEmailId());
        userHealthParamsDTO.setDeviceId(mobileDevice.getDeviceId());
        userHealthParamsDTO.setUserId(user.getUserId());
        UserHealthParams userHealthParams = Mappers.getMapper(UserHealthParamsMapper.class).toUserHealthParams(userHealthParamsDTO);
        userHealthParams.setDeviceId(mobileDevice);
        userHealthParams.setUserId(user);
        // Validation is pending - consuming too much time, putting it in TODO list
        return userHealthParamsRepository.save(userHealthParams);
    }

    public List<UserHealthParamsDTO> getAllUserHealthParams(){
        List<UserHealthParams> userHealthParamsList = (List<UserHealthParams>) userHealthParamsRepository.findAll();
        return Mappers.getMapper(UserHealthParamsMapper.class).toUserHealthParamsDTOList(userHealthParamsList);
    }

    public AggregationUserHealthParamsDTO getHealthMetricsDailyReportByUserId(long userId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new UserNotRegisteredException("User with Id " + userId + "not registered");
        }
        MobileDevice mobileDevice = mobileDeviceRepository.findByEmailId(user.getEmailId());
        if(mobileDevice == null) {
            throw new DeviceNotRegisteredException("Device not registered for the user Id "+userId);
        }
        return aggregationOfUserHealthMetrics(mobileDevice.getMobileNumber(), ReportEnum.DAILY);
    }

    public AggregationUserHealthParamsDTO aggregationOfUserHealthMetrics(long mobileNumber, ReportEnum reportEnum) throws Exception {
        List<UserHealthParams> userHealthParams = getHealthRecordsByMobileNumber(mobileNumber, reportEnum);
        return aggregationOfUserHealthMetrics(mobileNumber, userHealthParams);
    }

    private AggregationUserHealthParamsDTO aggregationOfUserHealthMetrics(long mobileNumber, List<UserHealthParams> userHealthParams) throws Exception {

        final double averageHeight = userHealthParams.stream()
            .map(UserHealthParams::getHeight).filter(Objects::nonNull)
            .collect(Collectors.averagingInt(Integer::intValue));

        final double averageWeight = userHealthParams.stream()
            .map(UserHealthParams::getWeight)
            .collect(Collectors.averagingInt(Integer::intValue));

        final double averageHeartRatePerMinutes = userHealthParams.stream()
            .map(UserHealthParams::getHearthRatePerMinutes)
            .collect(Collectors.averagingInt(Integer::intValue));

        final double averageCalories = userHealthParams.stream()
            .map(UserHealthParams::getCalories)
            .collect(Collectors.averagingInt(Integer::intValue));

        final double averageCaloriesBurn = userHealthParams.stream()
            .map(UserHealthParams::getCaloriesBurn)
            .collect(Collectors.averagingInt(Integer::intValue));

        // Calculate aggregation of multiple fields of user health parameters
        return AggregationUserHealthParamsDTO
            .builder()
            .mobileNumber(mobileNumber)
            .averageHeight(averageHeight)
            .averageWeight(averageWeight)
            .averageHearthRatePerMinutes(averageHeartRatePerMinutes)
            .averageCalories(averageCalories)
            .averageCaloriesBurn(averageCaloriesBurn).build();
    }

    public List<UserHealthParams> getHealthRecordsByMobileNumber(long mobileNumber, ReportEnum reportEnum) {
        MobileDevice mobileDevice = mobileDeviceRepository.findByMobileNumber(mobileNumber);
        if (mobileDevice == null) {
            throw new DeviceNotRegisteredException("Mobile number: " + mobileNumber + " not registered");
        }
        List<UserHealthParams> userHealthParams = new ArrayList<>();
        switch (reportEnum){
            case DAILY:
                userHealthParams = userHealthParamsRepository.findByMobileNumberAndCreatedDate(mobileDevice.getMobileNumber(), new Date());
            case WEEKLY:
                userHealthParams = userHealthParamsRepository.findByMobileNumberAndCreatedDateBetween(mobileDevice.getMobileNumber(), new Date(),
                    DateUtils.addDays(new Date(),ReportEnum.WEEKLY.getValue()));
            default:
                userHealthParams = userHealthParamsRepository.findByMobileNumber(mobileDevice.getMobileNumber());
        }

         return userHealthParams;
    }

}
