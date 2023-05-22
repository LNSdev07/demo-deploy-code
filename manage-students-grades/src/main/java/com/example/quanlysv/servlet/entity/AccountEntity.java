package com.example.quanlysv.servlet.entity;

public class AccountEntity {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long roleId;

    private Integer statusPasswordDefault;

    private String verification;

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public Integer getStatusPasswordDefault() {
        return statusPasswordDefault;
    }

    public void setStatusPasswordDefault(Integer statusPasswordDefault) {
        this.statusPasswordDefault = statusPasswordDefault;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
