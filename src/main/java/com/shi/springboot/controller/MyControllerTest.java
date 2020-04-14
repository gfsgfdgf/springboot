package com.shi.springboot.controller;

import com.shi.springboot.service.UserMapper;
import com.shi.springboot.userBean.MySyuser;
import com.shi.springboot.userBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shi.springboot.service.service;

@RestController
public class MyControllerTest {

    @Autowired
    private service service;

    @Autowired
    private UserMapper userMapper;

        @RequestMapping(value="/index")
        @ResponseBody
        public String myTest(@RequestParam Map<String, String> param, HttpServletRequest request){
            String name = param.get("name");
            System.out.println(name);

            return "hello world" + name;
        }

    @RequestMapping(value = "/fu")
    @ResponseBody
    public List<User> fuzzyCUser(HttpServletRequest request) {
        Map<String,Object> result = new HashMap<>();
        // List<MySyuser>list =service.select(result);
        List<User>list = userMapper.selectAll();
        //  result.put("list",list);
        request.getSession().setAttribute("LIST",list);
        //  return result;
        return list;
    }

    @RequestMapping(value="/getone")
    @GetMapping("{id}")
    @ResponseBody
    public String getone(@RequestParam String id){
        User mysyuser = userMapper.selectOne(id);

        return mysyuser+"";
    }

    @RequestMapping(value="/insert")
    public String add(@RequestBody User user) {
        userMapper.insert(user);
        return "nice";
    }

    @RequestMapping(value="/update")
    public String update(@RequestBody User user) {
        userMapper.update(user);
        return "update success";
    }

    @RequestMapping(value="/delete")
    public String delete(@RequestParam String id) {
        userMapper.delete(id);
        return "delete success";
    }
}
