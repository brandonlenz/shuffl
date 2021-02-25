package com.brandonalenz.shuffl.application.repository;

import com.brandonalenz.shuffl.application.model.Organization;
import com.brandonalenz.shuffl.application.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    List<User> findByOrganization(Organization organization);
}
