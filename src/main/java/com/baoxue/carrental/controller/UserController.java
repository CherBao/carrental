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
@Api(tags = "User management related interfaces")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/query")
    @ApiOperation("Paging query all user information interface")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return userService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("Query user information interface according to customer ID")
    public ResponseDto queryById(@PathVariable int id) {
        return userService.queryById(id);
    }

    @PostMapping()
    @ApiOperation("Add user interface")
    public ResponseDto add(@Valid @RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Update user information interface")
    public ResponseDto update(@Valid @RequestBody User user, @PathVariable int id) {
        return userService.update(user, id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Delete user interface")
    public ResponseDto delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
