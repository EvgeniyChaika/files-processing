package com.chaika.files.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by echaika on 03.11.2018
 */

public enum Role implements GrantedAuthority {
    USER,
    CUSTOMER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
