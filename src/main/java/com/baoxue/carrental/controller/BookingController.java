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
@Api(tags = "Booking management related interfaces")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/query")
    @ApiOperation("Paging query all booking record interface")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return bookingService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{order_no}")
    @ApiOperation("Query booking records according to order number interface")
    public ResponseDto queryByKey(@PathVariable String order_no) {
        return bookingService.queryByKey(order_no);
    }

    @GetMapping(value = "/query/user_id/{user_id}")
    @ApiOperation("Query booking records according to user id interface")
    public ResponseDto queryByUserId(@PathVariable int user_id) {
        return bookingService.queryByUserId(user_id);
    }

    @PostMapping(value = "/order")
    @ApiOperation("Booking interface")
    public ResponseDto order(@RequestBody Booking booking) {
        return bookingService.order(booking);
    }

    @PostMapping(value = "/pickup")
    @ApiOperation("Pick up the car interface")
    public ResponseDto pickup(@RequestBody Booking booking) {
        return bookingService.pickup(booking);
    }

    @PostMapping(value = "/return")
    @ApiOperation("Return the car interface")
    public ResponseDto returnBack(@RequestBody Booking booking) {
        return bookingService.returnBack(booking);
    }

    @PutMapping(value = "/{order_no}")
    @ApiOperation("Update booking record interface")
    public ResponseDto update(@Valid @RequestBody Booking booking, @PathVariable String order_no) {
        return bookingService.update(booking, order_no);
    }

    @DeleteMapping(value = "/{order_no}")
    @ApiOperation("Delete booking record interface")
    public ResponseDto delete(@PathVariable String order_no) {
        return bookingService.deleteByKey(order_no);
    }
}
