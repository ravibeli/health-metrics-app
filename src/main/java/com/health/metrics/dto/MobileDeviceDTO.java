package com.health.metrics.dto;

import com.health.metrics.dto.base.AbstractDeviceDTO;
import com.health.metrics.enums.DeviceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 6:01 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
public class MobileDeviceDTO extends AbstractDeviceDTO {
    private String emailId;
    private long mobileNumber;
    private DeviceType deviceType = DeviceType.MOBILE;
}
