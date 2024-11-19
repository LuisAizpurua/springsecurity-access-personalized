package com.sec.practice.oauth.persistence.util.fileproperty;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private String secret_key;

    private Long minute_exp;

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Long getMinute_exp() {
        return minute_exp;
    }

    public void setMinute_exp(Long minute_exp) {
        this.minute_exp = minute_exp;
    }
}
