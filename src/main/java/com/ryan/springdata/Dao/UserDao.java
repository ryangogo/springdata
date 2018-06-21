package com.ryan.springdata.dao;

import com.ryan.springdata.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

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
 * 5.支持属性的级联查询，若当前类有复合条件的属性 则优先使用，而不使用级联属性
 */
public interface UserDao extends Repository<User, Long> {

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

    //WHERE a.id > ?
    //注意 这是一个级联查询
    List<User> getByAddressIdGreaterThan(Long id);

    //查询id最大的user
    //使用query注解可以自定义JPQL语句以实现更灵活的查询
    @Query("select u from User u where u.id = (select max(u2.id) from User u2)")
    User getMaxIdUser();

    //为query注解传递参数的方式1：使用占位符
    @Query("SELECT u from User u where u.name = ?1 AND u.email = ?2")
    User selectUserByNameAndEmail(String name ,String email);

    //为query注解传递参数的方式2:命名参数的方式
    @Query("SELECT u from User u where u.name = :name AND u.email = :email")
    User selectUserByNameAndEmail2(@Param("name") String name ,@Param("email") String email);

    //两种写法都是可以的 不过第二种写法在参数传入之前需要先加上百分号
    //@Query("SELECT u from User u where u.name like %?1% AND u.email like %?2%")
    @Query("SELECT u from User u where u.name like ?1 AND u.email like ?2")
    List<User> selectUsersByNameLikeAndEmailLike(String name,String email);

    //还可以这样写（有红线的话直接忽略就好了）
    @Query("SELECT u from User u where u.name like %:name% AND u.email like %:email%")
    List<User> selectUsersByNameLikeAndEmailLike2(@Param("name") String name,@Param("email")String email);

    //将nativeQuery设置为true 就可以使用原生的sql进行查询
    @Query(value="select count(id) from user",nativeQuery = true)
    long selectUserTotal();

    @Query(value = "select name from User where id = :id", nativeQuery = true)
    String selectNameById(@Param("id") long id);

    //通过JPQL进行UODATE 和 DELETE操作 需要注意：
    //1.JPQL不支持insert操作
    //2.在执行修改操作的时候需要加上@Modifying注解
    //3.需要加上事务，否则无法通过（因此我新增了service以及其单元测试，并且加上了事务的支持）
    @Modifying
    @Query("UPDATE User u set u.email = :email where u.id = :id")
    int updateEmailById(@Param("email") String email, @Param("id") long id);
}
