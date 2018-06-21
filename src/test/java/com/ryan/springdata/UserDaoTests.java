package com.ryan.springdata;

import com.ryan.springdata.dao.UserDao;
import com.ryan.springdata.dao.UserDao3;
import com.ryan.springdata.dao.UserDao4;
import com.ryan.springdata.dao.UserDao5;
import com.ryan.springdata.entity.Address;
import com.ryan.springdata.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDao3 userDao3;

    @Autowired
    private UserDao4 userDao4;

    @Autowired
    private UserDao5 userDao5;

    @Test
	public void testGetById(){
		User user = userDao.getById((long)1);
		System.out.println(user);
	}

    @Test
    public void testGetByName(){
        User user = userDao.getByName("admin1");
        System.out.println(user);
    }

    @Test
    public void testGetByNameAndId(){
        User user = userDao.getByNameAndId("admin",(long)1);
        System.out.println(user);
    }

    @Test
    public void tesGetByIdLessThan(){
        List<User> listUsers = userDao.getByIdLessThan((long)8);
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testGetByNameLike(){
        List<User> listUsers = userDao.findByNameLike("%admin%");
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testGetByNameIn(){
        List<String> names = new ArrayList<String>();
        names.add("admin1");
        names.add("admin2");
        names.add("admin3");
        List<User> listUsers = userDao.getByNameIn(names);
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testGetByCreateTimeBetween() throws ParseException {
        String beforeTime = "2018:06:01";
        String afterTime = "2018:06:04";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        Date before = sdf.parse(beforeTime);
        Date after = sdf.parse(afterTime);
        List<User> listUsers = userDao.getByCreateTimeBetween(before, after);
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testGetByAddressIdGreaterThan(){
        List<User> listUsers = userDao.getByAddressIdGreaterThan((long)1);
        for(User user : listUsers){
            System.out.println(user.getAddress());
        }
    }

    /**
     * PagingAndSortingRepository接口的分页方法
     */
    @Test
    public void testPage() {
        //pageNo从0开始，第一页的pageNo为0
        int pageNo = 0;
        int pageSize = 5;
        Pageable pageable = new PageRequest(pageNo, pageSize);
        Page<User> all = userDao3.findAll(pageable);
        System.out.println("总记录数：" + all.getTotalElements());
        System.out.println("当前页码：" + all.getNumber());
        System.out.println("总页数：" + all.getTotalPages());
        System.out.println("当前页面的List：" + all.getContent());
        System.out.println("当前页面的记录数：" + all.getNumberOfElements());
    }

    /**
     * PagingAndSortingRepository接口的排序方法
     */
    @Test
    public void testSort() {
        //Sort.Order为排序条件，构造方法为public Sort(Sort.Order... orders) 也就是说在其中可以传入多个sort来进行排序
        //按照createTime来进行降序排序
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "createTime");
        Sort sort = new Sort(order1);
        Iterable<User> all = userDao3.findAll(sort);
        Iterator<User> iterator = all.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }
    }

    /**
     * PagingAndSortingRepository接口的分页+排序方法
     */
    @Test
    public void testPageAndSort() {
        //pageNo从0开始，第一页的pageNo为0
        int pageNo = 0;
        int pageSize = 5;
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "createTime");
        Sort sort = new Sort(order1);
        Pageable pageable = new PageRequest(pageNo, pageSize, sort);
        Page<User> all = userDao3.findAll(pageable);
        System.out.println("总记录数：" + all.getTotalElements());
        System.out.println("当前页码：" + all.getNumber());
        System.out.println("总页数：" + all.getTotalPages());
        System.out.println("当前页面的List：" + all.getContent());
        System.out.println("当前页面的记录数：" + all.getNumberOfElements());
    }

    /**
     * 添加一条新的数据并且返回数据信息
     */
    @Test
    public void testSaveAndFlush() {
        Address address = new Address();
        address.setId((long) 1);
        User user = new User();
        user.setName("测试返回");
        user.setPhone("1811112222");
        user.setEmail("XXYY@163.com");
        user.setPasswd("123456");
        user.setAvatar("1");
        user.setAboutme("eee");
        user.setType((byte) 1);
        user.setCreateTime(new Date());
        user.setEnable((byte) 1);
        user.setAgencyId(111);
        user.setAddress(address);
        user = userDao4.saveAndFlush(user);
        System.out.println(user.getId());
    }

    /**
     * 实现带有查询条件的分页查询，id>5的条件
     * <p/>
     * 调用JpaSpecificationExecutor 的 Page<T> findAll(Specification<T> spec,Pageable pageable)
     * Specification:封装了JpaCriteria查询的查询条件
     * Pageable:封装了请求分页的信息：例如pageNo，pageSize，sort
     */
    @Test
    public void testPageByCondition() {
        int pageNo = 4, pageSize = 5;
        Pageable pageable = new PageRequest(pageNo, pageSize);
        //通常使用Specification的匿名内部类
        Specification<User> specification = new Specification<User>() {
            /**
             *
             * @param *root 代表查询实体类
             * @param criteriaQuery 我们可以从中得到root对象，即告知JPA Criteria 查询要查询哪一个实体类，还可以
             *                      结合EntityManager对象得到最终查询的TypeQuery对象
             * @param *criteriaBuilder 用于创建criteria相关对象的工厂，当然可以从中获取到Predicate 对象
             * @return *Predicate类型，代表一个查询条件
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Predicate predicate = criteriaBuilder.gt(path, 9);
                return predicate;
            }
        };
        Page<User> all = userDao5.findAll(specification, pageable);
        System.out.println("总记录数：" + all.getTotalElements());
        System.out.println("当前页码：" + all.getNumber());
        System.out.println("总页数：" + all.getTotalPages());
        System.out.println("当前页面的List：" + all.getContent());
        System.out.println("当前页面的记录数：" + all.getNumberOfElements());

    }
    //-------------------------------------以下为使用@Query注解的查询------------------------------------------------------

    @Test
    public void testGetMaxIdUser(){
        User maxIdUser = userDao.getMaxIdUser();
        System.out.println(maxIdUser);
    }

    @Test
    public void testSelectUserByNameAndEmail(){
        User maxIdUser = userDao.selectUserByNameAndEmail("admin1","ryan@161.com");
        System.out.println(maxIdUser);
    }

    @Test
    public void testSelectUserByNameAndEmail2(){
        User maxIdUser = userDao.selectUserByNameAndEmail2("admin1","ryan@161.com");
        System.out.println(maxIdUser);
    }

    @Test
    public void testSelectUsersByNameLikeAndEmailLike(){
        List<User> listUsers = userDao.selectUsersByNameLikeAndEmailLike("%min%","%16%");
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testSelectUsersByNameLikeAndEmailLike2(){
        List<User> listUsers = userDao.selectUsersByNameLikeAndEmailLike2("min","16");
        for(User user : listUsers){
            System.out.println(user);
        }
    }

    @Test
    public void testSelectNameById() {
        String userName = userDao.selectNameById((long) 1);
        System.out.println(userName);
    }

    @Test
    public void testSelectTotalCount(){
        long result = userDao.selectUserTotal();
        System.out.println("--------------" + result + "--------------");
    }

}
