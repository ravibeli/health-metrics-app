package com.health.metrics.repository;

import com.health.metrics.entity.UserHealthParams;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:20 PM
 **/

@RepositoryRestResource(collectionResourceRel = "user_health_params", path = "user_health_params")
public interface UserHealthParamsRepository extends PagingAndSortingRepository<UserHealthParams, Long> {
    List<UserHealthParams> findByMobileNumber(Long mobileNumber);
}
