package com.db.service;

import com.db.entity.User;

import java.util.List;

public interface BaseService {

    User queryByUserId(int userId);

    int deleteByUser(User user);

    void inserUser(User user);

    int updateUserByUser(User user);

    List getLogs();
}
