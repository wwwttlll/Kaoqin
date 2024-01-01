package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Sign;
import com.example.demo.entity.User;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SignMapper extends BaseMapper<Sign> {
    @Select("SELECT COUNT(*) AS attendance_count, user_id, username FROM sign GROUP BY user_id, username")
    List<AttendanceResult> calculateAttendance();

    @Data
    class AttendanceResult {
        private int attendance_count;
        private String user_id;
        private String username;

        public int getAttendance_count() {
            return attendance_count;
        }

        public void setAttendance_count(int attendance_count) {
            this.attendance_count = attendance_count;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
