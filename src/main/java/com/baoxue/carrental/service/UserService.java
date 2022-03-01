package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.User;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseDto queryAll(){
        try{
            List<User> data =  userMapper.queryAll();
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryById(int id){
        try{
             User data =  userMapper.queryById(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto insert(User user){
        try{
            int data =  userMapper.insert(user);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(User user){
        try{
            int data =  userMapper.update(user);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto delete(int id){
        try{
            int data =  userMapper.delete(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
