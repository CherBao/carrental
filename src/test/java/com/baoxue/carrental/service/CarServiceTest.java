package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Car;
import com.baoxue.carrental.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {
    @Autowired
    private CarService carService;

    @Test
    void queryAll() {
        ResponseDto res = carService.queryAll(0,10);
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryById() {
        ResponseDto res = carService.queryById("A888888");
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryCarModelsWithStock() {
        ResponseDto res = carService.queryCarModelsWithStock();
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void queryStockByModel() {
        ResponseDto res = carService.queryStockByModel("Wuling Hongguang");
        assertTrue(res.isSuccess());
        assertNotNull(res.getData());
    }

    @Test
    void insert() {
        Car vehicle = new Car();
        vehicle.setId("苏F88888");
        vehicle.setModel("Wuling Hongguang");
        vehicle.setPrice(new BigDecimal("600"));
        ResponseDto res = carService.insert(vehicle);
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }

    @Test
    void update() {
        Car vehicle = new Car();
        vehicle.setId("A888888");
        vehicle.setModel("Wuling Hongguang");
        vehicle.setPrice(new BigDecimal("600"));
        ResponseDto res = carService.update(vehicle,"B888888");
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }

    @Test
    void delete() {
        ResponseDto res = carService.delete("A888888");
        assertTrue(res.isSuccess());
        assertEquals(res.getData(),1);
    }
}