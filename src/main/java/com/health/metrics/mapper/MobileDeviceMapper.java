package com.health.metrics.mapper;

import com.health.metrics.dto.MobileDeviceDTO;
import com.health.metrics.entity.MobileDevice;
import com.health.metrics.mapper.config.DeviceMapperConfig;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:36 PM
 **/

@Mapper(config = DeviceMapperConfig.class)
public abstract class MobileDeviceMapper {

    @InheritConfiguration(name = "mapDevice")
    @Mapping(source = "emailId", target = "emailId")
    @Mapping(source = "userId.userId", target = "userId")
    public abstract MobileDeviceDTO toMobileDeviceDTO(MobileDevice mobileDevice);

    @InheritInverseConfiguration(name = "mapDevice")
    @Mapping(source = "emailId", target = "emailId")
    public abstract MobileDevice toMobileDevice(MobileDeviceDTO mobileDeviceDTO);

    @InheritConfiguration(name = "mapDevice")
    public abstract List<MobileDeviceDTO> toMobileDeviceDTOList(List<MobileDevice> mobileDevices);


}
