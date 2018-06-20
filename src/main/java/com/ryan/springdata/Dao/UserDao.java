package com.ryan.springdata.Dao;

import com.ryan.springdata.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

/**
 * 在Repository子接口中生命方法
 * 1.不是随便声明的 需要符合一定的声明规范
 * 2.查询方法以find|get|read 开头
 * 3.涉及条件查询时，条件的属性用条件关键字连接
 * 4.要注意的是:条件属性以首字母大写
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

    /**
     * 根据姓名和id查询用户
     * @param name
     * @param id
     * @return
     */
    User getByNameAndId(String name,Long id);

    //WHERE id < ?
    List<User> getByIdLessThan(Long id);

    //WHERE id > ?
    List<User> getByIdGreaterThan(Long id);


    //WHERE name LIKE ?
    //敲黑板！！！！ 这里的参数在传入进来之前一定要加上百分号！！！！
    List<User> findByNameLike(String name);

    //where name in (?,?,?)
    List<User> getByNameIn(List<String> name);

    //WHERE createTime between ?1 and ?2
    List<User> getByCreateTimeBetween(Date before,Date after);


}
