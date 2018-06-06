package com.db.dao;

import com.db.entity.User;

import java.util.List;

public interface BaseDao {

    User queryByUserId(int userId);

    int deleteByUser(User user);

    void inserUser(User user);

    int updateUserByUser(User user);

    List getLogs();
}
