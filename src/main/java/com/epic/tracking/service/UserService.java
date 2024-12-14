package com.epic.tracking.service;

import com.epic.tracking.models.User;

public interface UserService {

    public void save(User user);
    public User findByUsername(String name);
}
