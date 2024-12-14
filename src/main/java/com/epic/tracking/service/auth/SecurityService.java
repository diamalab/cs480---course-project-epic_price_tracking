package com.epic.tracking.service.auth;

public interface SecurityService {
    public String findLoggedInUsername();
    public void autologin(String username, String password);

}
