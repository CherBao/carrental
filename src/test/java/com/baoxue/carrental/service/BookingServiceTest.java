package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
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
        ResponseDto res = bookingService.queryByKey("1646653009428");
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
        booking.setCar_id("A888888");
        booking.setPickup_date(new Timestamp(new Date().getTime()));
        booking.setReturn_date(new Timestamp(new Date().getTime()));
        ResponseDto res = bookingService.order(booking);
        assertTrue(res.isSuccess());
    }

    @Test
    void pickup() {
        Booking booking = new Booking();
        booking.setOrder_no("1646652526300");
        booking.setUser_id(2);
        booking.setCar_id("B888888");
        booking.setPickup_date(new Timestamp(new Date().getTime()));
        booking.setReturn_date(new Timestamp(new Date().getTime()));

        ResponseDto res = bookingService.pickup(booking);
        assertTrue(res.isSuccess());
    }

    @Test
    void returnBack() {
        Booking booking = new Booking();
        booking.setOrder_no("1646652526300");
        booking.setUser_id(2);
        booking.setCar_id("B888888");
        booking.setPickup_date(new Timestamp(new Date().getTime()));
        booking.setReturn_date(new Timestamp(new Date().getTime()));
        ResponseDto res = bookingService.returnBack(booking);
        assertTrue(res.isSuccess());
    }

    @Test
    void update() {
        String orderNO = "1646653009428";
        Booking booking = (Booking) bookingService.queryByKey(orderNO).getData();
        booking.setRent(new BigDecimal("500"));
        ResponseDto res = bookingService.update(booking,orderNO);
        assertTrue(res.isSuccess());
        booking = (Booking) bookingService.queryByKey(orderNO).getData();
        assertEquals(booking.getRent(),new BigDecimal("500"));
    }

    @Test
    void deleteByKey() {
        String orderNO = "1646311932705";
        ResponseDto res = bookingService.deleteByKey(orderNO);
        assertTrue(res.isSuccess());
    }
}