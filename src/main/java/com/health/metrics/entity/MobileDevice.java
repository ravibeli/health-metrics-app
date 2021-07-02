package com.health.metrics.entity;

import com.health.metrics.entity.base.Device;
import com.health.metrics.enums.DeviceType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:40 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_device")
public class MobileDevice extends Device {
    @NotNull
    @Column(name = "mobile_number", unique = true)
    private long mobileNumber;

    @NotNull
    @Column(name = "email_id", unique = true)
    private String emailId;

    @NotNull
    @Column(name = "device_type")
    private DeviceType deviceType = DeviceType.MOBILE;
}
