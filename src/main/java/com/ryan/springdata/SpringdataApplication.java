package com.ryan.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启springboot事务支持 在需要事务支持的方法上加上@Transactional注解即可表示该方法支持事务
@EnableTransactionManagement
@SpringBootApplication
public class SpringdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}
}
