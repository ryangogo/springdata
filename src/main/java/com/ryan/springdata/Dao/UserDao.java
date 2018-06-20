package com.ryan.springdata.Dao;

import com.ryan.springdata.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/6/20.
 */

public interface UserDao extends JpaRepository<User,Long> {

    /**
     * 根据id来获取对应的user
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     * 根据name获取对应的user
     * @param name
     * @return
     */
    User getByName(String name);
}
