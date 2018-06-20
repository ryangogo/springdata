package com.ryan.springdata;

import com.ryan.springdata.Dao.UserDao;
import com.ryan.springdata.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        User user = userDao.getByName("admin1");
        System.out.println(user);
    }

    @Test
    public void testGetByNameAndId(){
        User user = userDao.getByNameAndId("admin",(long)1);
        System.out.println(user);
    }

    /*@Test
    public void testGetByNameStartingWidthAndIdLessThan(){
        List<User> listUsers = userDao.getByNameStartingWidthAndIdLessThan("ad",(long)8);
        for(User user : listUsers){
            System.out.println(user);
        }
    }*/

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

}
