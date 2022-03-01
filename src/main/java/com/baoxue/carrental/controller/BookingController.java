package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
@Api(tags = "预定管理相关接口")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有预定记录接口")
    public ResponseDto queryAll() {
        return bookingService.queryAll();
    }

    @GetMapping(value = "/query/{userid}/{vehicleid}")
    @ApiOperation("根据键值查询预定记录接口")
    public ResponseDto queryByKey(@PathVariable int userid, @PathVariable int vehicleid) {
        return bookingService.queryByKey(userid, vehicleid);
    }

    @PostMapping(value = "/add")
    @ApiOperation("添加预定记录接口")
    public ResponseDto add(@RequestBody Booking booking) {
        return bookingService.insert(booking);
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新预定记录接口")
    public ResponseDto update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping(value = "/delete/{userid}/{vehicleid}")
    @ApiOperation("删除预定记录接口")
    public ResponseDto delete(@PathVariable int userid, @PathVariable int vehicleid) {
        return bookingService.deleteByKey(userid, vehicleid);
    }
}
