package com.health.metrics.repository;

import com.health.metrics.entity.MobileDevice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:20 PM
 **/

@RepositoryRestResource(collectionResourceRel = "mobile", path = "mobile")
public interface MobileRegistrationRepository extends PagingAndSortingRepository<MobileDevice, Long> {
    MobileDevice findByMobileNumber(long mobileNumber);
    MobileDevice findByEmailId(String emailId);
}
