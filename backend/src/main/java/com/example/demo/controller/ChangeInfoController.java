package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ChangeInfoController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/ChangeInfo/{userId}")
    public ResponseEntity<String> updateUserInfo(@PathVariable int userId, @RequestBody User requestData) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            return new ResponseEntity<>("用户不存在", HttpStatus.NOT_FOUND);
        }
        user.setPhone_number(requestData.getPhone_number());
        user.setEmail(requestData.getEmail());
        int rowsAffected = userMapper.updateById(user);
        if (rowsAffected > 0) {
            return new ResponseEntity<>("员工信息更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("员工信息更新失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}