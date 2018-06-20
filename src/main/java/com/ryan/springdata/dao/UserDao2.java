package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ryan on 2018/6/20.
 */

/**
 * JPQL不支持insert操作，但是其接口的实现类CrudRepository中有save方法可以完成insert操作。
 * 我这里调用save方法的demo在Service中
 * 除了save方法 还有很多方法 可以自己查看一下 看命名基本就知道是怎么用了 如果还有问题可以百度一下
 */
public interface UserDao2 extends CrudRepository<User, Long> {

}
