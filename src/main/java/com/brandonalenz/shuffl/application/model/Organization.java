package com.brandonalenz.shuffl.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(name = "ORGANIZATION_SEQ", sequenceName = "organization_sequence")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANIZATION_SEQ")
    @Column(nullable = false)
    long id;

    @Column(nullable = false)
    String name;

    @OneToMany(
            mappedBy = "organization",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<User> users;

    protected Organization() {}

    public Organization(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }
}
