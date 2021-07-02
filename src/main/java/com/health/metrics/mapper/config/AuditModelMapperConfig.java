package com.health.metrics.mapper.config;

import com.health.metrics.dto.base.AuditModelDTO;
import com.health.metrics.entity.base.AuditModel;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:40 PM
 **/

@MapperConfig
public interface AuditModelMapperConfig {
    void mapAuditModel(AuditModel auditModel, @MappingTarget AuditModelDTO auditModelDTO);
}




