package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.registerDTO;
import com.example.demo.entity.User;

public interface UserService extends IService<User> {

    String register(registerDTO registerDTo);

    String login(LoginDTO loginDto);
}