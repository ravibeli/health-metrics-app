package com.health.metrics.service;

import com.health.metrics.mapper.MobileDeviceMapper;
import com.health.metrics.repository.MobileRegistrationRepository;
import com.health.metrics.repository.UserRepository;
import com.health.metrics.dto.MobileDeviceDTO;
import com.health.metrics.entity.MobileDevice;
import com.health.metrics.entity.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ravibeli
 * @project health-metrics-app
 * @created on 11 Sep, 2020 7:19 PM
 **/

@Slf4j
@Service
public class MobileRegistrationService {

    @Autowired
    MobileRegistrationRepository mobileDeviceRepository;

    @Autowired
    UserRepository userRepository;

    public MobileDevice getDeviceByMobileNumber(Integer mobileNumber){
        // Validation is pending - consuming too much time, putting it in TODO list
        return mobileDeviceRepository.findByMobileNumber(mobileNumber);
    }

    public List<MobileDeviceDTO> getDevices(){
        List<MobileDevice> mobileDevices = (List<MobileDevice>) mobileDeviceRepository.findAll();
        return Mappers.getMapper(MobileDeviceMapper.class).toMobileDeviceDTOList(mobileDevices);
    }

    public MobileDeviceDTO createMobileDevice(MobileDeviceDTO deviceDto){
        // Validation is pending - consuming too much time, putting it in TODO list
        User user = userRepository.findByEmailId(deviceDto.getEmailId());
        deviceDto.setUserId(user.getUserId());

        MobileDevice mobileDevice = Mappers.getMapper(MobileDeviceMapper.class).toMobileDevice(deviceDto);
        log.info("After MobileDevice setting user = {}", mobileDevice);
        mobileDevice.setUserId(user);
        mobileDevice = mobileDeviceRepository.save(mobileDevice);
        log.info("After save MobileDevice = {}", mobileDevice);
        return Mappers.getMapper(MobileDeviceMapper.class).toMobileDeviceDTO(mobileDevice);
    }
}
