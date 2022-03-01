package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.domain.Booking;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;

    public ResponseDto queryAll(){
        try{
            List<Booking> data =  bookingMapper.queryAll();
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryByKey(int userid, int vehicleid){
        try{
            Booking data =  bookingMapper.queryByKey(userid,vehicleid);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto insert(Booking booking){
        try{
            int data =  bookingMapper.insert(booking);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(Booking booking){
        try{
            int data =  bookingMapper.update(booking);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto deleteByKey(int userid, int vehicleid){
        try{
            int data =  bookingMapper.delete(userid,vehicleid);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
