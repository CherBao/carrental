package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select(value = "select * from users order by id limit #{offset}, #{limit}")
    List<User> queryAll(int offset, int limit);

    @Select(value = "select * from users where id = #{id}")
    User queryById(int id);

    @Insert("insert into users(id, name, phone,password) values (#{id}, #{name}, #{phone}, #{password})")
    int insert(User user);

    @Delete("delete from users where id=#{id}")
    int delete(int id);

    @Update("update users set name=#{user.name}, phone=#{user.phone} , password=#{user.password} where id=#{userid}")
    int update(User user, int userid);
}
