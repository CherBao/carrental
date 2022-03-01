package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select(value = "select * from user")
     List<User> queryAll();

    @Select(value = "select * from user where id = #{id}")
     User queryById(int id);

    @Insert("insert into user(id, name, phone) VALUES (#{id}, #{name}, #{phone})")
    int insert(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(int id);

    @Update("UPDATE user SET name=#{name}, phone=#{phone} WHERE id=#{id}")
    int update(User user);
}
