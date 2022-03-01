package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.User;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有用户信息接口")
    public ResponseDto queryAll() {
        return userService.queryAll();
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("根据客户ID查询用户信息接口")
    public ResponseDto queryById(@PathVariable int id) {
        return userService.queryById(id);
    }

    @PostMapping(value = "/add")
    @ApiOperation("添加用户接口")
    public ResponseDto add(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新用户信息接口")
    public ResponseDto update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation("删除用户接口")
    public ResponseDto delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
