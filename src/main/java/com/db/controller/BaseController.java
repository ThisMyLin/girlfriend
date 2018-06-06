package com.db.controller;

import com.db.entity.User;
import com.db.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/checkUser")
    @ResponseBody
    public String add(){

        return "{\"Status\":\"ok\",\"Text\":\"登录成功\"}";
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }
}
