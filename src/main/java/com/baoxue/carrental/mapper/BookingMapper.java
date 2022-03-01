package com.baoxue.carrental.mapper;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingMapper {
    @Select(value = "select * from booking")
    List<Booking> queryAll();

    @Select(value = "select * from booking where userid = #{userid} and vehicleid=#{vehicleid}")
    Booking queryByKey(int userid, int vehicleid);

    @Insert("insert into booking(userid, vehicleid, status, rent, begdate, tenancy) " +
            "VALUES (#{userid}, #{vehicleid}, #{status}, #{rent}, #{begdate}, #{tenancy}")
    int insert(Booking booking);

    @Delete("DELETE FROM booking from booking where userid = #{userid} and vehicleid=#{vehicleid}")
    int delete(int userid, int vehicleid);

    @Update("UPDATE booking SET status=#{status},rent= #{rent}, begdate=#{begdate}, tenancy=#{tenancy} " +
            "where userid = #{userid} and vehicleid=#{vehicleid}")
    int update(Booking booking);
}
