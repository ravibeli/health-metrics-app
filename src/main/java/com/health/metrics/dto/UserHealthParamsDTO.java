package com.health.metrics.dto;

import com.health.metrics.entity.base.AbstractUserHealthParams;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:12 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
public class UserHealthParamsDTO extends AbstractUserHealthParams {
    private long userHealthParamId;
    private long userId;
    private long mobileNumber;
    private long deviceId;
}
