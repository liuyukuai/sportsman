package com.sysware.cloud.security.auth;


public interface AuthService {
    String login(String username, String password);
    String refresh(String oldToken);
}
