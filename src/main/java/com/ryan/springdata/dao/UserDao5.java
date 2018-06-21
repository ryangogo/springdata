package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2018/6/21.
 * <p/>
 * JpaSpecificationExecutor继承自JpaRepository继承自PagingAndSortingRepository继承自CrudRepository继承自Repository
 */
public interface UserDao5 extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
