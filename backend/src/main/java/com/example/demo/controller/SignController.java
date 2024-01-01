package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.entity.Sign;
import com.example.demo.entity.User;
import com.example.demo.mapper.SignMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class SignController {
    @Autowired
    private SignMapper signMapper;
    public List<SignMapper.AttendanceResult> getAttendance() {
        return signMapper.calculateAttendance();
    }
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/selectallsign",method = RequestMethod.GET)
    public ResponseEntity<Object> selectallsign(){

        List<Sign> allsign = signMapper.selectList(new QueryWrapper<>());

        if (!allsign.isEmpty()) {
            return ResponseEntity.ok(allsign);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found");
        }
    }
    @RequestMapping(value = "/selectsignbyuser", method = RequestMethod.POST)
    public ResponseEntity<Object> selectsignbyuser(@RequestParam(required = false) String username,
                                                   @RequestParam(required = false) String date) {
        QueryWrapper<Sign> queryWrapper = new QueryWrapper<>();
        System.out.println(username);
        System.out.println(date);
        if (!username.equals("")) {
            queryWrapper.eq("username", username);
        }

        if (StringUtils.isNotBlank(date)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
                Date parsedDate = dateFormat.parse(date);
                Timestamp timestamp = new Timestamp(parsedDate.getTime());
// 获取日期的起始时间和结束时间
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parsedDate);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                Date startDate = calendar.getTime();
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                Date endDate = calendar.getTime();

                // 使用日期范围查询
                queryWrapper.between("time", startDate, endDate);

            } catch (ParseException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
            }
        }

        List<Sign> res = signMapper.selectList(queryWrapper);

        if (!res.isEmpty()) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sign not found");
        }
    }

    @RequestMapping(value = "/selectsignbyuserid", method = RequestMethod.POST)
    public ResponseEntity<Object> selectsignbyuserid(@RequestParam(required = true) String userid ) {
        QueryWrapper<Sign> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userid);
        List<Sign> res = signMapper.selectList(queryWrapper);

        if (!res.isEmpty()) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sign not found");
        }
    }
    @RequestMapping(value = "/signsupplement", method = RequestMethod.POST)
    public ResponseEntity<Object> supplement(@RequestParam(required = true) String username, @RequestParam(required = true) Date date) {
        System.out.println(username);
        System.out.println(date);
        Sign sign = new Sign();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);

        sign.setUsername(username);
        sign.setUser_id(user.getUser_id());
        sign.setTime(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 设置时间为当天的8:30
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 获取当天8:30的Date对象
        Date targetTime = calendar.getTime();
        if (date.after(targetTime)) {
            sign.setStatus("迟到");
        } else {
            sign.setStatus("出勤");
        }
        boolean res = signMapper.insert(sign) > 0;
        if (res) {
            return ResponseEntity.ok("补签成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("补签失败，请重试。");
        }
    }
    @RequestMapping(value = "/statistics", method = RequestMethod.POST)
    public ResponseEntity<Object> statistics() {

        Sign sign = new Sign();
        List<SignMapper.AttendanceResult> res = signMapper.calculateAttendance();

        if (res.size() > 0) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("没有查找到数据");
        }
    }
}
