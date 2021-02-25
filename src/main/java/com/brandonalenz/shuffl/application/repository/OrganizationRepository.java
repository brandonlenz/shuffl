package com.brandonalenz.shuffl.application.repository;

import com.brandonalenz.shuffl.application.model.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    Organization findById(long id);

    List<Organization> findByName(String name);
}
