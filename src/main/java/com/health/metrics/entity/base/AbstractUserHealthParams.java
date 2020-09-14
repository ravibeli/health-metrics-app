package com.health.metrics.entity.base;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 6:29 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUserHealthParams extends AbstractAuditModel {

    @NotNull
    @Column(name = "height")
    private Integer height;

    @NotNull
    @Column(name = "weight")
    private Integer weight;

    @NotNull
    @Column(name = "hearth_rate")
    private Integer hearthRatePerMinutes;

    @NotNull
    @Column(name = "calories")
    private Integer calories;

    @NotNull
    @Column(name = "calories_burn")
    private Integer caloriesBurn;
}
