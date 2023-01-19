package com.bit2bit.qaapi.domain.service;

import com.bit2bit.qaapi.domain.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long userId);
    User create(User user);
    User update(Long userId, User user);
    User delete(Long userId);
}
