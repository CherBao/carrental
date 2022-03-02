package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/book")
@Api(tags = "预定管理相关接口")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有预定记录接口")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return bookingService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{order_no}")
    @ApiOperation("根据订单号查询预定记录接口")
    public ResponseDto queryByKey(@PathVariable String order_no) {
        return bookingService.queryByKey(order_no);
    }

    @GetMapping(value = "/query/user_id/{user_id}")
    @ApiOperation("根据订单号查询预定记录接口")
    public ResponseDto queryByUserId(@PathVariable int user_id) {
        return bookingService.queryByUserId(user_id);
    }

    @PostMapping(value = "/order")
    @ApiOperation("预定下单接口")
    public ResponseDto order(@RequestBody Booking booking) {
        return bookingService.order(booking);
    }

    @PostMapping(value = "/take")
    @ApiOperation("取车接口")
    public ResponseDto take(@RequestBody Booking booking) {
        return bookingService.take(booking);
    }

    @PostMapping(value = "/return")
    @ApiOperation("还车接口")
    public ResponseDto returnBack(@RequestBody Booking booking) {
        return bookingService.returnBack(booking);
    }

    @PutMapping(value = "/{order_no}")
    @ApiOperation("更新预定记录接口")
    public ResponseDto update(@Valid @RequestBody Booking booking, @PathVariable String order_no) {
        return bookingService.update(booking, order_no);
    }

    @DeleteMapping(value = "/{order_no}")
    @ApiOperation("取消预定接口")
    public ResponseDto delete(@PathVariable String order_no) {
        return bookingService.deleteByKey(order_no);
    }
}
