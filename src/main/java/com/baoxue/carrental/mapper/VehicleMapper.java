package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.Vehicle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleMapper {
    @Select(value = "select * from vehicle order by id")
    List<Vehicle> queryAll();

    @Select(value = "select * from vehicle where id = #{id}")
    Vehicle queryById(int id);

    @Select(value = "select * from vehicle where status = #{status} order by id")
    List<Vehicle> queryByStatus(String status);

    @Insert("insert into vehicle(id, type, status, price) VALUES (#{id}, #{type}, #{status}, #{price})")
    int insert(Vehicle vehicle);

    @Delete("DELETE FROM vehicle WHERE id=#{id}")
    int delete(int id);

    @Update("UPDATE vehicle SET type=#{type}, price=#{price}, status=#{status} WHERE id=#{id}")
    int update(Vehicle vehicle);
}
