package com.erendarici.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;

    private HashMap specs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public HashMap getSpecs() {
        return specs;
    }

    public void setSpecs(HashMap specs) {
        this.specs = specs;
    }
}
