package com.health.metrics.mapper;

import com.health.metrics.dto.UserHealthParamsDTO;
import com.health.metrics.entity.UserHealthParams;
import com.health.metrics.mapper.config.UserHealthParamsMapperConfig;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:50 PM
 **/

@Mapper(config = UserHealthParamsMapperConfig.class)
public interface UserHealthParamsMapper {

    UserHealthParamsMapper INSTANCE = Mappers.getMapper(UserHealthParamsMapper.class);

    @InheritConfiguration(name = "mapAbstractUserHealthParams")
    @Mapping(source = "userId", target = "userId.userId")
    @Mapping(source = "deviceId", target = "deviceId.deviceId")
    public abstract UserHealthParams toUserHealthParams(UserHealthParamsDTO userHealthParamsDTO);

    @InheritConfiguration(name = "mapAbstractUserHealthParamsDTO")
    @Mapping(source = "userId.userId", target = "userId")
    @Mapping(source = "deviceId.deviceId", target = "deviceId")
    public abstract UserHealthParamsDTO toUserHealthParamsDTO(UserHealthParams userHealthParams);

    @InheritConfiguration(name = "mapAbstractUserHealthParamsDTO")
    public abstract List<UserHealthParamsDTO> toUserHealthParamsDTOList(List<UserHealthParams> userHealthParamsList);
}
