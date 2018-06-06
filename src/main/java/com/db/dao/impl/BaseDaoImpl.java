package com.db.dao.impl;

import com.db.dao.BaseDao;
import com.db.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    public User queryByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, userId);
    }

    public int deleteByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        if(session.get(User.class,user.getAdminId()) != null){
            try {
                session.delete(user);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public void inserUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public int updateUserByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        if(session.get(User.class,user.getAdminId()) != null){
            try {
                session.update(user);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public List getLogs() {
        String sql = "select * from Apache..Test";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        System.err.println(list+"---------------------------------------------------------------------------------------");
        return list;
    }
}
