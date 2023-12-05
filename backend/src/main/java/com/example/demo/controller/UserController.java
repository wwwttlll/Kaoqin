package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.entity.test;
import com.example.demo.mapper.UserMapper;
import com.example.demo.tools.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
        public ResponseEntity<Object> login(@RequestBody User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        System.out.println(username);
        System.out.println(password);
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginUser.getUsername());
        User storedUser =  userMapper.selectOne(queryWrapper);
        if (storedUser != null && storedUser.getPassword().equals(loginUser.getPassword())) {
//            String token = JwtTokenProvider.generateToken(storedUser.getUser_id(), storedUser.getUsername(), storedUser.getRole());
            Map<String, Object> userDataMap = new HashMap<>();
            userDataMap.put("userId", storedUser.getUser_id());
            userDataMap.put("username", storedUser.getUsername());
            userDataMap.put("role", storedUser.getRole());
            userDataMap.put("status", 1);
            userDataMap.put("message", "success");
            return ResponseEntity.ok(userDataMap);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);

        boolean  res = userMapper.insert(user) > 0;

        if (res) {
            return ResponseEntity.ok("注册成功！");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败，请重试。");
        }
    }
}

