package com.health.metrics.mapper;

import com.health.metrics.mapper.config.AuditModelMapperConfig;
import com.health.metrics.dto.UserDTO;
import com.health.metrics.entity.User;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:49 PM
 **/
@Mapper(config = AuditModelMapperConfig.class)
public abstract class UserMapper {

    @InheritInverseConfiguration(name = "mapAuditModel")
    public abstract User toUser(UserDTO userDTO);

    @InheritConfiguration(name = "mapAuditModel")
    public abstract UserDTO toUserDTO(User user);

    @InheritConfiguration(name = "mapAuditModel")
    public abstract List<UserDTO> toUserDTOList(List<User> users);

}
