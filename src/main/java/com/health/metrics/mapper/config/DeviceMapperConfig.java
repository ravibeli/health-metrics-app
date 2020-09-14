package com.health.metrics.mapper.config;

import com.health.metrics.entity.base.AbstractDevice;
import com.health.metrics.dto.base.AbstractDeviceDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:34 PM
 **/

@MapperConfig
public interface DeviceMapperConfig extends AuditModelMapperConfig {
    @InheritConfiguration(name = "mapAuditModel")
    @Mapping(source = "userId.userId", target = "userId")
    void mapDevice(AbstractDevice device, @MappingTarget AbstractDeviceDTO deviceDTO);
}