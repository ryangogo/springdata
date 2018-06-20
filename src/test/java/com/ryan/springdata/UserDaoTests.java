package com.ryan.springdata;

import com.ryan.springdata.Dao.UserDao;
import com.ryan.springdata.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/6/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
	public void testGetById(){
		User user = userDao.getById((long)1);
		System.out.println(user);
	}

    @Test
    public void testGetByName(){
        User user = userDao.getByName("admin");
        System.out.println(user);
    }

}
