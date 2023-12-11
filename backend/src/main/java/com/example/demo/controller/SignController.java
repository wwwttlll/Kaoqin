package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SignController {
    @Autowired
    private SignMapper signMapper;
    @RequestMapping(value = "/selectsign",method = RequestMethod.GET)
    public void selectsign(@RequestParam Date date){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("time", email);
    }
}
