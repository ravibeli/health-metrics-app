package com.health.metrics.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:01 PM
 **/

@Setter
@Getter
@ToString(callSuper = true)
public abstract class AbstractUserHealthParamsDTO extends AbstractAuditModelDTO {
    private Integer height;
    private Integer weight;
    private Integer hearthRatePerMinutes;
    private Integer calories;
    private Integer caloriesBurn;
}
