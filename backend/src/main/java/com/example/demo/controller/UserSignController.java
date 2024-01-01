package com.example.demo.controller;

import com.example.demo.entity.Sign;
import com.example.demo.mapper.UserSignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

@RestController
public class UserSignController {

    @Autowired
    private UserSignMapper signMapper;

    /**
     * 上班打卡（签到）
     *
     * @param userId
     * @return
     */
    @PostMapping("/signIn")
    public boolean signIn(Integer userId) {
        Sign sign = new Sign();
        sign.setTime(new Date());
        sign.setUser_id(userId);

        sign.setStatus("出勤"); // 空字符串表示没有迟到或早退

        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        if (currentHour > 9 || (currentHour == 9 && currentMinute > 0)) {
            sign.setStatus("迟到");
        }

        signMapper.insert(sign);

        return true;
    }


    @GetMapping(value="/getSignRecords/{userId}")
    public List<Sign> queryApplyByUserName(@PathVariable int userId) {
        List<Sign> signList = signMapper.queryApplyByUserName(userId);
        return signList;
    }

//    @GetMapping(value="/getSignType/{userId}")
//    public String getSignType(@PathVariable int userId) {
//        String type = "";
//        Sign latestSign = signMapper.selectLatestByUsername(userId);
//        if (latestSign != null) {
//            type = latestSign.getType();
//        }
//        return type;
//    }
}
