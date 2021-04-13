package com.zensar.userservice.service;

import com.zensar.userservice.model.User;

import java.util.List;

public interface UserService {
    public long getCount(List<User> users);

    public List<User> getUniqueUserCount(List<User> users);

    public List<User> updateUser(List<User> user,User userData, int userId);
}
