package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Excuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.mapper.ExcuseMapper;
import java.util.List;

@RestController
public class ExcuseController {
    @Autowired
    private ExcuseMapper excuseMapper ;
    @RequestMapping(value = "/getexecuse",method = RequestMethod.GET)
    public ResponseEntity<Object>getexecuse(){
        List<Excuse> allexcuse = excuseMapper.selectList(new QueryWrapper<>());

        if (!allexcuse.isEmpty()) {
            return ResponseEntity.ok(allexcuse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found");
        }
    }

    @RequestMapping(value = "/updateexcuse",method = RequestMethod.POST)
    public ResponseEntity<Object>updateexcuse(@RequestBody Excuse excuse){
        System.out.println("updateexcuse");
        UpdateWrapper<Excuse> updateWrapper = new UpdateWrapper<>();
        System.out.println(excuse.getUser_id());
        updateWrapper.eq("user_id",excuse.getUser_id());
        int updateResult = excuseMapper.update(excuse, updateWrapper);
        System.out.println(updateResult);

        if (updateResult == 1) {
            return ResponseEntity.ok("Excuse updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Excuse update failed");
        }

    }
}
