package com.shi.springboot.userDao;

import com.shi.springboot.userBean.MySyuser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    List<MySyuser> select(Map<String, Object> userMap);
}
