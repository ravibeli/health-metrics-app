package com.health.metrics.mapper.config;

import com.health.metrics.dto.base.AbstractUserHealthParamsDTO;
import com.health.metrics.entity.base.AbstractUserHealthParams;
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
    void mapAbstractUserHealthParamsDTO(AbstractUserHealthParams abstractUserHealthParams, @MappingTarget
        AbstractUserHealthParamsDTO abstractUserHealthParamsDTO);

    @InheritConfiguration(name = "mapAuditModel")
    void mapAbstractUserHealthParams(AbstractUserHealthParamsDTO abstractUserHealthParamsDTO, @MappingTarget
        AbstractUserHealthParams abstractUserHealthParams);
}
