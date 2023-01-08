package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.registerDTO;
import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户注册
     */
    @PostMapping("/register")//@Validated
    public CommonResult register(@RequestBody registerDTO registerDto){
        String obj = userService.register(registerDto);
        if(obj.equals("注册成功")){
            return CommonResult.success(obj);
        }else{
            return CommonResult.failed(obj);
        }

    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginDTO loginDto){

        log.info(loginDto.toString());
        String ans = userService.login(loginDto);

        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("login_name", loginDto.getLoginName());
        User uer=userMapper.selectOne(wrapper);
        if(ans.equals("用户名密码正确")){
            return new CommonResult(200,"登录成功",uer);
        }
        return CommonResult.failed(ans);
    }
}
