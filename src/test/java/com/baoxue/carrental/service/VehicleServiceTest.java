package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Vehicle;
import com.baoxue.carrental.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceTest {
    @Autowired
    private VehicleService vehicleService;

    @Test
    void queryAll() {
        ResponseDto res = vehicleService.queryAll(0,10);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryById() {
        ResponseDto res = vehicleService.queryById(2);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryByStatus() {
        ResponseDto res = vehicleService.queryByStatus('0');
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void insert() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(99);
        vehicle.setType("五菱红光");
        vehicle.setPrice(new BigDecimal("600"));
        ResponseDto res = vehicleService.insert(vehicle);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }

    @Test
    void update() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(4);
        vehicle.setType("五菱红光");
        vehicle.setPrice(new BigDecimal("600"));
        ResponseDto res = vehicleService.update(vehicle,4);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }

    @Test
    void delete() {
        ResponseDto res = vehicleService.delete(3);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }
}