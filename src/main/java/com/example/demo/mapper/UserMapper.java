package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.DTO.registerDTO;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {


    @Select("select id from user where login_name = #{loginName}")
    String selectByUsername(String loginName);

    @Select("select password from user where login_name = #{loginName}")
    String selectPdByUsername(String loginName);

}
