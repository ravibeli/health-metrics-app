package com.health.metrics.mapper.config;

import com.health.metrics.dto.base.AbstractAuditModelDTO;
import com.health.metrics.entity.base.AbstractAuditModel;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:40 PM
 **/

@MapperConfig
public interface AuditModelMapperConfig {
    void mapAuditModel(AbstractAuditModel auditModel, @MappingTarget AbstractAuditModelDTO auditModelDTO);
}




