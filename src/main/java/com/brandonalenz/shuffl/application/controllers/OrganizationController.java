package com.brandonalenz.shuffl.application.controllers;

import com.brandonalenz.shuffl.application.model.Organization;
import com.brandonalenz.shuffl.application.model.User;
import com.brandonalenz.shuffl.application.repository.OrganizationRepository;
import com.brandonalenz.shuffl.application.services.ShufflService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class OrganizationController {

    private final Logger log = LoggerFactory.getLogger(OrganizationController.class);
    private final OrganizationRepository organizationRepository;
    private final ShufflService shufflService;

    protected OrganizationController(OrganizationRepository organizationRepository,
                                     ShufflService shufflService) {
        this.organizationRepository = organizationRepository;
        this.shufflService = shufflService;
    }

    @GetMapping("/organizations")
    public Iterable<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    @GetMapping("/organizations/{organizationId}")
    public Organization getOrganization(@PathVariable(value = "organizationId") long id) {
        return organizationRepository.findById(id);
    }

    @GetMapping("/organizations/{organizationId}/users")
    public List<User> getUsersForOrganization(@PathVariable(value = "organizationId") long id) {
        Organization organization = organizationRepository.findById(id);
        return organization.getUsers();
    }

    @GetMapping("/shuffl")
    public List<Set<User>> shuffl(@RequestParam(value = "organizationId", defaultValue = "1") long organizationId,
                                  @RequestParam(value = "groupSize", defaultValue = "2") int groupSize) {
        Organization organization = organizationRepository.findById(organizationId);
        return shufflService.getGroupsFromOrganization(organization, groupSize);
    }
}
