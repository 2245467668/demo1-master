package com.example.demo.Controller;


import com.example.demo.DTO.registerDTO;
import com.example.demo.Service.RegisterService;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
     @Autowired
     RegisterService registerService;
     @PostMapping(value = "/register")
     @CrossOrigin
    public Result register(@RequestBody registerDTO registerDTO){
         return registerService.register(registerDTO);
     }

}
