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
        private int attendanceCount;
        private String userId;
        private String username;

    }
}
