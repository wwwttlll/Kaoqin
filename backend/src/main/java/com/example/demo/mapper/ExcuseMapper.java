package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.entity.Excuse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExcuseMapper extends BaseMapper<Excuse> {
//    int updateExcuse(@Param(Constants.WRAPPER) UpdateWrapper<Excuse> updateWrapper);
}