package com.example.demo.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.registerDTO;
import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String register(registerDTO ro) {
        String ans = istrue(ro);
        if(ans.equals("OK")){
            User user = new User();
            user.setUserName(ro.getUsername());user.setLoginName(ro.getLoginName());user.setPassword(ro.getPassword()); //MD5Utils.code(ro.getPassword())
            userMapper.insert(user);
            return "注册成功";
        }
        return ans;
    }

    @Override
    public String login(LoginDTO loginDto) {

        String pd = userMapper.selectPdByUsername(loginDto.getLoginName());
        if(pd==null){
            return "用户名错误";
        }else if(pd.equals(loginDto.getPassword())){  //MD5Utils.code(loginDto.getPassword()))
            return "用户名密码正确";
        }
        return "密码错误";
    }

    public String istrue(registerDTO ro){
        if(ro.getUsername()==null||ro.getUsername()==""){
            return "昵称不能为空";
        }
        if(ro.getLoginName()==null||ro.getLoginName()==""){
            return "账号不能为空";
        }
        if(userMapper.selectByUsername(ro.getLoginName())!=null){
            return "该账号已经存在";
        }
        if(ro.getPassword()==null||ro.getPassword()==""){
            return "密码不能为空";
        }
        if(ro.getPassword().length()>16||ro.getPassword().length()<4){
            return "密码长度只能在4~16位";
        }
        return "OK";
    }
}
