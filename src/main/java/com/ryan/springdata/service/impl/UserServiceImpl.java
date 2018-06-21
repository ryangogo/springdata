package com.ryan.springdata.service.impl;

import com.ryan.springdata.dao.UserDao;
import com.ryan.springdata.dao.UserDao2;
import com.ryan.springdata.entity.Address;
import com.ryan.springdata.entity.User;
import com.ryan.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDao2 userDao2;


    @Transactional
    @Override
    public int modifyEmailById(String email, long id) {
        return userDao.updateEmailById(email, id);
    }

    @Transactional
    @Override
    public void addUsers() {
        Address address = new Address();
        address.setId((long) 1);
        List<User> users = new ArrayList<User>();
        for (int i = 'a'; i < 'z'; i++) {
            //5	admin5	18100002045	ryan@165.com	hahahha	123456	1	1	2018-06-05	1	1	1
            User user = new User();
            user.setName(String.valueOf((char) i));
            user.setPhone("1811111111" + (char) i);
            user.setEmail((char) i + "" + (char) i + "@163.com");
            user.setPasswd("123456");
            user.setAvatar("1");
            user.setAboutme(String.valueOf(i));
            user.setType((byte) 1);
            user.setCreateTime(new Date());
            user.setEnable((byte) 1);
            user.setAgencyId(111);
            user.setAddress(address);
            users.add(user);
        }
        Iterable<User> save = userDao2.save(users);
        Iterator<User> iterator = save.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            System.out.println("---------" + u.getId() + "----------");
        }
    }
}
