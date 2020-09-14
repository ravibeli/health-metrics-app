package com.health.metrics.service;

import com.health.metrics.mapper.UserHealthParamsMapper;
import com.health.metrics.repository.UserHealthParamsRepository;
import com.health.metrics.repository.UserRepository;
import com.health.metrics.dto.AggregationUserHealthParamsDTO;
import com.health.metrics.dto.UserHealthParamsDTO;
import com.health.metrics.entity.MobileDevice;
import com.health.metrics.entity.User;
import com.health.metrics.entity.UserHealthParams;
import com.health.metrics.repository.MobileDeviceRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
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
    MobileDeviceRepository mobileDeviceRepository;

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

    public List<UserHealthParamsDTO> getUserHealthParamsByMobileNumber(long mobileNumber){
        List<UserHealthParams> userHealthParamsList = (List<UserHealthParams>) userHealthParamsRepository.findAll();
        return Mappers.getMapper(UserHealthParamsMapper.class).toUserHealthParamsDTOList(userHealthParamsList);
    }


    public AggregationUserHealthParamsDTO aggregationOfUserHealthMetrics(final long mobileNumber) throws Exception {

        MobileDevice mobileDevice = mobileDeviceRepository.findByMobileNumber(mobileNumber);

        if(mobileDevice == null) {
            throw new Exception("Mobile number" + mobileNumber + " not registered");
        }

        List<UserHealthParams> userHealthParams = userHealthParamsRepository.findByMobileNumber(mobileDevice.getMobileNumber());

        final double averageHeight = userHealthParams.stream()
            .map(UserHealthParams::getHeight).filter(Objects::nonNull)
            .collect(Collectors.averagingInt(Integer::intValue));

        final double averageWeight = userHealthParams.stream()
            .map(UserHealthParams::getWeight)
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
            .mobileNumber(mobileDevice.getMobileNumber())
            .averageHeight(averageHeight)
            .averageWeight(averageWeight)
            .averageCalories(averageCalories)
            .averageCaloriesBurn(averageCaloriesBurn).build();
    }

}
