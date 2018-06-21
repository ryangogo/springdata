package com.ryan.springdata;


import com.ryan.springdata.service.UserService;
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
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testModifyEmailById() {
        int result = userService.modifyEmailById("hehe@qq.com", (long) 5);
        System.out.println("--------------" + result + "--------------");
    }

    @Test
    public void testAddUsers() {
        userService.addUsers();
    }
}
