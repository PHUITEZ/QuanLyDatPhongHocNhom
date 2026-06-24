package com.group5.main.model;

import java.io.Serializable;

// Lớp cha trừu tượng (Abstraction) - người dùng không được tạo trực tiếp đối tượng User
public abstract class User implements Serializable {
    private String fullName;
    private String phone;
    private String email;

    public User(String fullName, String phone, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}