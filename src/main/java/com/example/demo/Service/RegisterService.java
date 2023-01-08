package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.DTO.registerDTO;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;

public interface RegisterService {
    public Result register(registerDTO registerDTO);

}
