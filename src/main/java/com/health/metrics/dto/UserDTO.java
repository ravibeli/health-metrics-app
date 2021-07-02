package com.health.metrics.dto;

import com.health.metrics.dto.base.AuditModelDTO;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:46 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
public class UserDTO extends AuditModelDTO {
    private long userId;
    @NonNull
    private String emailId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private int age;
}
