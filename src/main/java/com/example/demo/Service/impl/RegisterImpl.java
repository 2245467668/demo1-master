package com.example.demo.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.DTO.registerDTO;
import com.example.demo.Service.RegisterService;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl extends ServiceImpl<UserMapper, User>  implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result register(registerDTO registerDTO) {
        String loginName=registerDTO.getLoginName();
        String password=registerDTO.getPassword();
        String sex = registerDTO.getSex();
        if(StringUtils.isEmpty(loginName)){
            return new Result(400,"账号不能为空","");
        }
        if(StringUtils.isEmpty(password)){
            return new Result(400,"密码不能为空","");
        }

        User user = getUserInfo(registerDTO);

        if(user!=null){
            return new Result(400,"用户已经注册",user);
        }else{
            user = new User();
            save(user);
            return new Result(200,"",user);
        }

    }

    private User getUserInfo(registerDTO registerDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",registerDTO.getLoginName());
        queryWrapper.eq("password",registerDTO.getPassword());
        User user;

            // 从数据库查询用户信息
        user = getOne(queryWrapper);

        return user;
    }
}
