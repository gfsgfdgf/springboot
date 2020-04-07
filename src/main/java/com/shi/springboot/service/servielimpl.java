package com.shi.springboot.service;

import com.shi.springboot.userBean.MySyuser;
import com.shi.springboot.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class servielimpl implements  service{

    @Autowired
    private UserDao userDao;

    @Override
    public List<MySyuser> select(Map<String, Object> userMap) {
        return userDao.select(userMap);
    }
}
