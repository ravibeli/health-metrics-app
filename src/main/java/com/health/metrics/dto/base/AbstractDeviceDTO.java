package com.health.metrics.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:35 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
public abstract class AbstractDeviceDTO extends AbstractAuditModelDTO {
    private long deviceId;
    private long userId;
}
