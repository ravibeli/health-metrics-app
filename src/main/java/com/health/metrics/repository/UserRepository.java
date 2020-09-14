package com.health.metrics.repository;

import com.health.metrics.entity.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUserId(@Param("userId") long userId);
	User findByEmailId(@Param("emailId") String emailId);
}
