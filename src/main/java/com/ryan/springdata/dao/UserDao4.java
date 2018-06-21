package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/6/21.
 *
 * 可以实现分页查询
 */
public interface UserDao4 extends JpaRepository<User, Long> {
}
