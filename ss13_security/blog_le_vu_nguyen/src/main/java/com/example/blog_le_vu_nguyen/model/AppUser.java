package com.example.blog_le_vu_nguyen.model;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER",//
uniqueConstraints = {//
        @UniqueConstraint(name = "APP_USER_UK",columnNames = "User_name")

} )
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
