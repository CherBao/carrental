package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.BookingMapper;
import com.baoxue.carrental.mapper.CarMapper;
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
    private CarMapper carMapper;

    public ResponseDto queryAll(int offset, int limit) {
        try {
            if (offset < 0 || limit <= 0) throw new Exception("Illegal paging parameter!");
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

    @Transactional
    public ResponseDto order(Booking booking) {
        try {
            int v = carMapper.updateStatus(booking.getCar_id(), Constants.CAR_BOOKED);
            if (v == 0) throw new Exception("Failed to update car status!");
            String order_no = String.valueOf(System.currentTimeMillis());
            booking.setOrder_no(order_no);
            booking.setStatus(Constants.BOOK_WAITING);
            int b = bookingMapper.insert(booking);
            if (b == 0) throw new Exception("Failed to add booking record!");
            return ResponseDto.builder().isSuccess(true).data(order_no).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    @Transactional
    public ResponseDto pickup(Booking booking) {
        try {
            int v = carMapper.updateStatus(booking.getCar_id(), Constants.CAR_USING);
            if (v == 0) throw new Exception("Failed to update car status!");
            int b = bookingMapper.updateStatus(booking.getOrder_no(), Constants.BOOK_PROCESSING);
            if (b == 0) throw new Exception("Failed to update booking status!");
            return ResponseDto.builder().isSuccess(true).data(booking.getOrder_no()).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    @Transactional
    public ResponseDto returnBack(Booking booking) {
        try {
            int v = carMapper.updateStatus(booking.getCar_id(), Constants.CAR_IN_STOCK);
            if (v == 0) throw new Exception("Failed to update car status!");
            int b = bookingMapper.updateStatus(booking.getOrder_no(), Constants.BOOK_FINISHED);
            if (b == 0) throw new Exception("Failed to update booking status!");
            return ResponseDto.builder().isSuccess(true).data(booking.getOrder_no()).message("ok").build();
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

    @Transactional
    public ResponseDto deleteByKey(String order_no) {
        try {
            Booking booking = bookingMapper.queryByKey(order_no);
            if(booking==null) throw new Exception("Can not find the booking record!");
            int v = carMapper.updateStatus(booking.getCar_id(),Constants.CAR_IN_STOCK);
            if (v == 0) throw new Exception("Failed to update car status!");
            int b = bookingMapper.deleteByKey(order_no);
            if (b == 0) throw new Exception("Failed to update booking status!");
            return ResponseDto.builder().isSuccess(true).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
