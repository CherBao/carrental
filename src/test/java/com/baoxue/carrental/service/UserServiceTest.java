package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.User;
import com.baoxue.carrental.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void queryAll() {
        ResponseDto res = userService.queryAll(0,10);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryById() {
        ResponseDto res = userService.queryById(2);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void insert() {
        User user = new User();
        user.setId(99);
        user.setName("李清照");
        user.setPhone("15555555555");
        ResponseDto res = userService.insert(user);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void update() {
        User user = new User();
        user.setId(99);
        user.setName("李清照");
        user.setPhone("15555555554");
        ResponseDto res = userService.update(user,99);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
        res = userService.queryById(99);
        assertEquals(((User)res.getData()).getPhone(),user.getPhone());

    }

    @Test
    void delete() {
        ResponseDto res = userService.delete(4);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }
}