package com.ryan.springdata.service;

/**
 * Created by Administrator on 2018/6/20.
 */
public interface UserService {

    void modifyEmailById(String email, long id);

    void addUsers();
}
