package com.example.demo.controller;

import com.example.demo.entity.Excuse;
import com.example.demo.mapper.ExcuseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LeaveController {
    @Autowired
    private ExcuseMapper excuseMapper;

    @RequestMapping(value="/Apply/AddApply", method = RequestMethod.POST)
    public void applyLeave(@RequestBody Excuse request) {
        Excuse excuse = createExcuse(request.getBegin_time(), request.getEnd_time(), request.getReason(), request.getType(),request.getUser_id());
        excuseMapper.insert(excuse);
    }

    @GetMapping(value="/Apply/ApplyList/{userId}")
    public List<Excuse> queryApplyByEmpId(@PathVariable Integer userId) {
        List<Excuse> excuseList = excuseMapper.queryApplyByEmpId(userId);
        return excuseList;
    }

    private Excuse createExcuse(Date beginTime, Date endTime, String reason, String type,int User_id) {
        Excuse excuse = new Excuse();
        excuse.setBegin_time(beginTime);
        excuse.setEnd_time(endTime);
        excuse.setReason(reason);
        excuse.setType(type);
        // 默认是正在审核中
        excuse.setStatus("待批");
        excuse.setUser_id(User_id);
        return excuse;
    }

}