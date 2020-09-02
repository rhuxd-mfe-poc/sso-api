package org.rh.uxd.sso;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Contact {
    private String id;
    private String name;
    private String address;
    private String email;

    // constructors
    public Contact() {}

    public Contact(String id) {
        this.id = id;
    }

    // accessor methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}