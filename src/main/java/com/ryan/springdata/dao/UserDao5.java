package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import com.ryan.springdata.repositories.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Ryan on 2018/6/21.
 *
 * JpaSpecificationExecutor继承自JpaRepository继承自PagingAndSortingRepository继承自CrudRepository继承自Repository
 *
 * 开发的时候使用这个，spring data jpa里面为我们提供的方法就基本都可以使用了
 *
 */
public interface UserDao5 extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, MyRepository {
}
