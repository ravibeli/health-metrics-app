package com.health.metrics.entity;

import com.health.metrics.entity.base.AbstractUserHealthParams;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 6:40 PM
 **/

@Setter
@Getter
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, of = {"userHealthParamId"})
@Table(name = "user_health_params")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserHealthParams extends AbstractUserHealthParams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "health_id")
    private long userHealthParamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "mobile_number")
    private long mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private MobileDevice deviceId;
}
