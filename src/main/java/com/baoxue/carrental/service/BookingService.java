package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.BookingMapper;
import com.baoxue.carrental.mapper.VehicleMapper;
import com.baoxue.carrental.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Slf4j
public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private VehicleMapper vehicleMapper;

    public ResponseDto queryAll(int offset, int limit) {
        try {
            if (offset < 0 || limit <= 0) throw new Exception("分页参数非法!");
            List<Booking> data = bookingMapper.queryAll(offset, limit);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryByKey(String order_no) {
        try {
            Booking data = bookingMapper.queryByKey(order_no);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryByUserId(int user_id) {
        try {
            List<Booking> data = bookingMapper.queryByUserId(user_id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto order(Booking booking) {
        try {
            booking.setOrder_no(String.valueOf(System.currentTimeMillis()));
            booking.setStatus(Constants.BOOK_WAITTING);
            int data = bookingMapper.insert(booking);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    @Transactional
    public ResponseDto take(Booking booking) {
        try {
            int v = vehicleMapper.updateStatus(booking.getVehicle_id(), Constants.VEHICLE_RENTED);
            if (v == 0) throw new Exception("更新车辆状态失败");
            int b = bookingMapper.updateStatus(booking.getOrder_no(), Constants.BOOK_PROCESSING);
            if (b == 0) throw new Exception("更新订单状态失败");
            return ResponseDto.builder().isSuccess(true).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    @Transactional
    public ResponseDto returnBack(Booking booking) {
        try {
            int v = vehicleMapper.updateStatus(booking.getVehicle_id(), Constants.VEHICLE_IDLE);
            if (v == 0) throw new Exception("更新车辆状态失败");
            int b = bookingMapper.updateStatus(booking.getOrder_no(), Constants.BOOK_FINISHED);
            if (b == 0) throw new Exception("更新订单状态失败");
            return ResponseDto.builder().isSuccess(true).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(Booking booking, String orderNo) {
        try {
            int data = bookingMapper.update(booking, orderNo);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto deleteByKey(String order_no) {
        try {
            int data = bookingMapper.deleteByKey(order_no);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
