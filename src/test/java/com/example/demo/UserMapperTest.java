package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("插入数据")
    public void testInsert(){
        User user=new User(1,"test","t123","男","test1@qq.com","满都镇", "地址");
        Integer id=userMapper.insert(user);
        System.out.printf(id.toString());
    }

    @Test
    @DisplayName("根据id查找")
    public void testSelectById(){
        User user=userMapper.selectById(1);
        System.out.println(user.toString());
    }

    @Test
    @DisplayName("查找所有")
    public void testSelectAll(){
        List userList=userMapper.selectObjs(null);
        System.out.println(userList.size());
    }



    @Test
    @DisplayName("删除")
    public void testDelete(){
        userMapper.deleteById(1);
    }
}
