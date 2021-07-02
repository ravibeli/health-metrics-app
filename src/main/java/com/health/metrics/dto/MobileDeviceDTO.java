package com.health.metrics.dto;

import com.health.metrics.dto.base.DeviceDTO;
import com.health.metrics.enums.DeviceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 6:01 PM
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MobileDeviceDTO extends DeviceDTO {
    private String emailId;
    private long mobileNumber;
    private DeviceType deviceType = DeviceType.MOBILE;
}
