package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.HashMap;
import java.util.List;
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
    @RequestMapping(value = "/selectallusers", method = RequestMethod.POST)
    public ResponseEntity<Object> selectAllUsers() {
        List<User> allUsers = userMapper.selectList(new QueryWrapper<>());

        if (!allUsers.isEmpty()) {
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found");
        }
    }


    @RequestMapping(value = "/selectuserbyusername", method = RequestMethod.POST)
    public ResponseEntity<Object> selectUserByUsername(@RequestParam("username")  String username){
        System.out.println(username);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> res  = userMapper.selectList(queryWrapper);
        if(res.size() > 0){
            return ResponseEntity.ok(res);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    @RequestMapping(value = "/selectuserbyphone", method = RequestMethod.POST)
    public ResponseEntity<Object> selectUserByPhone(@RequestParam String phone){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone_number", phone);
        List<User> res  = userMapper.selectList(queryWrapper);
        if(res.size() > 0){
            return ResponseEntity.ok(res);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    @RequestMapping(value = "/selectuserbyemail", method = RequestMethod.POST)
    public ResponseEntity<Object> selectUserByEmail(@RequestParam String email){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        List<User> res  = userMapper.selectList(queryWrapper);
        if(res.size() > 0){
            return ResponseEntity.ok(res);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}

