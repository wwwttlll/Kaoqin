package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.entity.Excuse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExcuseMapper extends BaseMapper<Excuse> {
//    int updateExcuse(@Param(Constants.WRAPPER) UpdateWrapper<Excuse> updateWrapper);
    @Select("SELECT * FROM excuse WHERE user_id = #{user_id}")
    List<Excuse> queryApplyByEmpId(int user_id);
}