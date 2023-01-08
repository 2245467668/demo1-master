package com.example.demo.Service;

import com.example.demo.entity.Result;
import com.example.demo.DTO.LoginDTO;

public interface LoginService {
    public Result login(LoginDTO loginDTO);
}
