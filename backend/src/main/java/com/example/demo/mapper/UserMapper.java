package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("UPDATE user SET password=#{password}, username=#{username}, role=#{role}, money_per_hour=#{moneyPerHour}, phone_number=#{phoneNumber}, email=#{email} WHERE user_id=#{userId}")
    int updateById(User user);
}