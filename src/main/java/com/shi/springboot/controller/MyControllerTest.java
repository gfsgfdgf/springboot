package com.shi.springboot.controller;

import com.shi.springboot.userBean.MySyuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shi.springboot.service.service;

@RestController
public class MyControllerTest {

    @Autowired
    private service service;

        @RequestMapping(value="/index")
        @ResponseBody
        public String myTest(@RequestParam Map<String, String> param, HttpServletRequest request){
            String name = param.get("name");
            System.out.println(name);

            return "hello world" + name;
        }

    @RequestMapping(value = "/fu")
    @ResponseBody
    public List<MySyuser> fuzzyCUser(HttpServletRequest request) {
        Map<String,Object> result = new HashMap<>();
        List<MySyuser>list =service.select(result);
        //  result.put("list",list);
        request.getSession().setAttribute("LIST",list);
        //  return result;
        return list;


    }

}
