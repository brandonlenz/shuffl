package com.brandonalenz.shuffl.application.services;

import com.brandonalenz.shuffl.application.controllers.UserController;
import com.brandonalenz.shuffl.application.model.Organization;
import com.brandonalenz.shuffl.application.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShufflService {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public List<Set<User>> getGroupsFromOrganization(Organization organization, int groupSize) {
        List<Set<User>> groups = new ArrayList<>(); // TODO: Represent as a "Group" Object?
        List<User> users = organization.getUsers();

        if (groupSize <= 0) {
            throw new IllegalArgumentException("Group size must a positive integer.");
        } else if (groupSize >= users.size()) {
            groups.add(new HashSet<>(users));
        } else {
            Collections.shuffle(users);

            Iterator<User> iterator = users.iterator();

            while(iterator.hasNext()) {
                Set<User> group = new HashSet<>();
                for (int i = 0; i < groupSize && iterator.hasNext(); i++) {
                    group.add(iterator.next());
                }
                groups.add(group);
            }
        }

        return groups;
    }
}
