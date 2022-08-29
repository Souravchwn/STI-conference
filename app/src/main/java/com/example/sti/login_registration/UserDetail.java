package com.example.sti.login_registration;

import org.jetbrains.annotations.Contract;

public class UserDetail {

    private String firstName;
    private String phone;
    private String address;

    public UserDetail(String firstName, String phone, String address) {
        this.firstName = firstName;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String Name) {
        this.firstName = Name;
    }

    public String getLastName() {
        return phone;
    }

    public void setLastName(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
