package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ryan on 2018/6/21.
 * <p/>
 * PagingAndSortingRepository是CrudRepository的子接口
 * 有两个方法 分别是Iterable<T> findAll(Sort var1)以及 Page<T> findAll(Pageable var1);
 * 这两个方法用于分页和排序
 * 因为不需要对数据库做修改 方法直接写在Test当中
 */
public interface UserDao3 extends PagingAndSortingRepository<User, Long> {

}
