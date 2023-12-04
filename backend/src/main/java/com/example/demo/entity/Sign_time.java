package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.xml.crypto.Data;
import java.util.Date;

@TableName("sign_time")
public class Sign_time {
    @TableId
    private Integer sign_time_id;
    private Date begin_time;
    private Date end_time;
    private int user_id;

    public Integer getSign_time_id() {
        return sign_time_id;
    }

    public void setSign_time_id(Integer sign_time_id) {
        this.sign_time_id = sign_time_id;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
