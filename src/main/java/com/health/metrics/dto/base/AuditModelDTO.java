package com.health.metrics.dto.base;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:02 PM
 **/
@Setter
@Getter
public abstract class AuditModelDTO {
    private Date createdDate;
    private Date updatedDate;
}
