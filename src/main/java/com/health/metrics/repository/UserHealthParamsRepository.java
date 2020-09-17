package com.health.metrics.repository;

import com.health.metrics.entity.UserHealthParams;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:20 PM
 **/

@RepositoryRestResource(collectionResourceRel = "health_report", path = "health_report")
public interface UserHealthParamsRepository extends PagingAndSortingRepository<UserHealthParams, Long> {
    List<UserHealthParams> findByMobileNumber(Long mobileNumber);
    List<UserHealthParams> findByMobileNumberAndCreatedDate(long mobileNumber, Date createdDate);
    List<UserHealthParams> findByMobileNumberAndCreatedDateBetween(long mobileNumber, Date startDate, Date endDate);
}
