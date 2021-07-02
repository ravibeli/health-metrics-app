package com.health.metrics.mapper.config;

import com.health.metrics.dto.base.UserHealthParamsDTO;
import com.health.metrics.entity.base.UserHealthParams;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:47 PM
 **/

@Mapper
public interface UserHealthParamsMapperConfig extends AuditModelMapperConfig {
    @InheritConfiguration(name = "mapAuditModel")
    void mapAbstractUserHealthParamsDTO(UserHealthParams abstractUserHealthParams, @MappingTarget
        UserHealthParamsDTO abstractUserHealthParamsDTO);

    @InheritConfiguration(name = "mapAuditModel")
    void mapAbstractUserHealthParams(UserHealthParamsDTO abstractUserHealthParamsDTO, @MappingTarget
        UserHealthParams abstractUserHealthParams);
}
