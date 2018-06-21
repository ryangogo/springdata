package com.ryan.springdata.repositories.impl;

import com.ryan.springdata.entity.User;
import com.ryan.springdata.repositories.MyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2018/6/21.
 */
public class UserDao5Impl implements MyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void test() {
        User user = entityManager.find(User.class, (long) 2);
        System.out.println(user);
    }

}
