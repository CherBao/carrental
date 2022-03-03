package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.domain.Car;
import com.baoxue.carrental.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingMapper {
    @Select(value = "select * from booking order by order_no limit #{offset}, #{limit} ")
    List<Booking> queryAll(int offset, int limit);

    @Select(value = "select * from booking where order_no = #{order_no} order by order_no")
    Booking queryByKey(String order_no);

    @Select(value = "select * from booking where user_id = #{user_id} order by order_no")
    List<Booking> queryByUserId(int user_id);

    @Insert("insert into booking(order_no, user_id, car_id, status, rent, pickup_date, return_date) " +
            "values (#{order_no}, #{user_id}, #{car_id}, #{status}, #{rent}, #{pickup_date}, #{return_date})")
    int insert(Booking booking);

    @Delete("delete from booking where order_no = #{order_no}")
    int deleteByKey(String order_no);

    @Update("update booking set car_id=#{booking.car_id}, status=#{booking.status}, rent= #{booking.rent}, pickup_date=#{booking.pickup_date}, return_date=#{booking.return_date} " +
            "where order_no = #{orderNo}")
    int update(Booking booking, String orderNo);

    @Update("update booking set status = #{status} where order_no = #{orderNo}")
    int updateStatus(String orderNo, char status);

    @Select(value = "select * from booking where model = #{user_id} order by order_no")
    List<Car> queryConditonCars(String model, long pickup_date, long return_date);
}
