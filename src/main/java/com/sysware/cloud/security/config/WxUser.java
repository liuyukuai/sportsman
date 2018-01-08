package com.sysware.cloud.security.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;

public class WxUser implements UserDetails {
    private final String id;
    private final String nickName;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Timestamp lastUpdatePasswordDate;

    public WxUser(
            String id,
            String nickName,
            String password,
            String email,
            Collection<? extends GrantedAuthority> authorities,
            Timestamp lastUpdatePasswordDate) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastUpdatePasswordDate = lastUpdatePasswordDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Timestamp getLastPasswordResetDate() {
        return lastUpdatePasswordDate;
    }
}
