package com.db.service.impl;

import com.db.dao.BaseDao;
import com.db.entity.User;
import com.db.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;

    public User queryByUserId(int userId) {
        return baseDao.queryByUserId(userId);
    }

    public int deleteByUser(User user) {
        return baseDao.deleteByUser(user);
    }

    public void inserUser(User user) {
        baseDao.inserUser(user);
    }

    public int updateUserByUser(User user) {
        return baseDao.updateUserByUser(user);
    }

    public List getLogs() {
        return baseDao.getLogs();
    }
}
