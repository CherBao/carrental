package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.User;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseDto queryAll(int offset, int limit) {
        try {
            if (offset < 0 || limit <= 0) throw new Exception("Illegal paging parameter!");
            List<User> data = userMapper.queryAll(offset, limit);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryById(int id) {
        try {
            User data = userMapper.queryById(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto insert(User user) {
        try {
            int data = userMapper.insert(user);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(User user, int id) {
        try {
            int data = userMapper.update(user, id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto delete(int id) {
        try {
            int data = userMapper.delete(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
