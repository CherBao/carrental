package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;

    @Test
    void queryAll() {
        ResponseDto res = bookingService.queryAll(0,10);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryByKey() {
        ResponseDto res = bookingService.queryByKey("2022030200000");
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryByUserId() {
        ResponseDto res = bookingService.queryByUserId(1);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void order() {
        Booking booking = new Booking();
        booking.setUser_id(1);
        booking.setVehicle_id(1);
        booking.setTake_date(new Timestamp(new Date().getTime()));
        ResponseDto res = bookingService.order(booking);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }

    @Test
    void take() {
        Booking booking = new Booking();
        booking.setOrder_no("2022030200001");
        booking.setUser_id(2);
        booking.setVehicle_id(2);
        booking.setTake_date(new Timestamp(new Date().getTime()));
        ResponseDto res = bookingService.take(booking);
        assertTrue(res.isSuccess());
    }

    @Test
    void returnBack() {
        Booking booking = new Booking();
        booking.setOrder_no("2022030200000");
        booking.setUser_id(1);
        booking.setVehicle_id(1);
        booking.setTake_date(new Timestamp(new Date().getTime()));
        ResponseDto res = bookingService.returnBack(booking);
        assertTrue(res.isSuccess());
    }

    @Test
    void update() {
        String orderNO = "2022030200000";
        Booking booking = (Booking) bookingService.queryByKey(orderNO).getData();
        booking.setTenancy(1000);
        ResponseDto res = bookingService.update(booking,orderNO);
        assertTrue(res.isSuccess());
        booking = (Booking) bookingService.queryByKey(orderNO).getData();
        assertEquals(booking.getTenancy(),1000);
    }

    @Test
    void deleteByKey() {
        String orderNO = "20220302000004";
        ResponseDto res = bookingService.deleteByKey(orderNO);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),0);
    }
}