package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.User;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理相关接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有用户信息接口")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return userService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("根据客户ID查询用户信息接口")
    public ResponseDto queryById(@PathVariable int id) {
        return userService.queryById(id);
    }

    @PostMapping()
    @ApiOperation("添加用户接口")
    public ResponseDto add(@Valid @RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("更新用户信息接口")
    public ResponseDto update(@Valid @RequestBody User user, @PathVariable int id) {
        return userService.update(user, id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除用户接口")
    public ResponseDto delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
