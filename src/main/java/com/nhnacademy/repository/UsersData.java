package com.nhnacademy.repository;

import com.nhnacademy.domain.User;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsersData implements UserRepository {
    Map<String, Object> users = new ConcurrentHashMap<>();

    @Override
    public User getUser(String id) {
        return (User)this.users.get(id);
    }

    @Override
    public Map<String, Object> getUsers() {
        return this.users;
    }

    @Override
    public void add(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        User userForModify = (User) users.get(user.getId());

        userForModify.setName(user.getName());
        userForModify.setPassword(user.getPassword());
        userForModify.setProfileFileName(user.getProfileFileName());
    }

    @Override
    public void remove(String id) {
        this.users.remove(id);
    }

}
