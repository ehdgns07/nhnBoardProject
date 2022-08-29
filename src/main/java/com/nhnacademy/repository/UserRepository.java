package com.nhnacademy.repository;

import com.nhnacademy.domain.User;
import java.util.Map;

public interface UserRepository {
    void add(User user);
    void modify(User user);
    void remove(String id);

    User getUser(String id);
    Map<String, Object> getUsers();

}
