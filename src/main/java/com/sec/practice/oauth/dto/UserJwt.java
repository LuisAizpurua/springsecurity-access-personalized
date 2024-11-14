package com.sec.practice.oauth.dto;

import java.io.Serializable;
import java.util.Date;

public class UserJwt implements Serializable {

    private String username;

    private Date date;

    private String jwt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
