package com.shi.springboot.service;

import com.shi.springboot.userBean.MySyuser;

import java.util.List;
import java.util.Map;

public interface service {

    List<MySyuser> select(Map<String, Object> userMap);
}
