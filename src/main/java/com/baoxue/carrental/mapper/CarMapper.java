package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.Car;
import com.baoxue.carrental.dto.CarModelStockDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    @Select(value = "select * from car order by id limit #{offset}, #{limit}")
    List<Car> queryAll(int offset, int limit);

    @Select(value = "select * from car where status='0' and model=#{model}")
    List<Car> queryStockByModel(String model);

    @Select(value = "select * from car where id = #{id}")
    Car queryById(String id);

    @Select(value = "select model, count(*) as stock from car where status='0' group by model")
    List<CarModelStockDto> queryCarModels();

    @Insert("insert into car(id, model, status, price) values (#{id}, #{model}, #{status}, #{price})")
    int insert(Car car);

    @Delete("delete from car where id=#{id}")
    int delete(String id);

    @Update("update car set model=#{car.model}, price=#{car.price}, status=#{car.status} where id=#{id}")
    int update(Car car, String id);

    @Update("update car set status=#{status} where id=#{id}")
    int updateStatus(String id, char status);
}
