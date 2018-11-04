package com.chaika.files.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by echaika on 03.11.2018
 */

public enum Role implements GrantedAuthority {
    STUDENT,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
