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
    @Select(value = "select * from vehicle order by id limit #{offset}, #{limit}")
    List<Vehicle> queryAll(int offset, int limit);

    @Select(value = "select * from vehicle where id = #{id}")
    Vehicle queryById(int id);

    @Select(value = "select * from vehicle where status = #{status} order by id")
    List<Vehicle> queryByStatus(char status);

    @Insert("insert into vehicle(id, type, status, price) values (#{id}, #{type}, #{status}, #{price})")
    int insert(Vehicle vehicle);

    @Delete("delete from vehicle where id=#{id}")
    int delete(int id);

    @Update("update vehicle set type=#{vehicle.type}, price=#{vehicle.price}, status=#{vehicle.status} where id=#{id}")
    int update(Vehicle vehicle, int id);

    @Update("update vehicle set status=#{status} where id=#{id}")
    int updateStatus(int id, char status);
}
