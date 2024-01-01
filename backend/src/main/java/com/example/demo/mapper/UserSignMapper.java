package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserSignMapper extends BaseMapper<Sign>{
    @Select("SELECT * FROM sign WHERE user_id = #{user_id}")
    List<Sign> queryApplyByUserName(int user_id);

    @Select("SELECT * FROM sign WHERE user_id = #{user_id} ORDER BY time DESC LIMIT 1")
    Sign selectLatestByUsername(int user_id);
}
