package com.ryan.springdata;

import com.ryan.springdata.Dao.UserDao;
import com.ryan.springdata.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringdataApplicationTests {

	@Test
	public void contextLoads() {

	}

}
