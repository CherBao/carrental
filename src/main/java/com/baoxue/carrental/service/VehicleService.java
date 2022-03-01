package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Vehicle;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;

    public ResponseDto queryAll(){
        try{
            List<Vehicle> data =  vehicleMapper.queryAll();
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryById(int id){
        try{
            Vehicle data =  vehicleMapper.queryById(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryByStatus(String status){
        try{
            List<Vehicle> data =  vehicleMapper.queryByStatus(status);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto insert(Vehicle vehicle){
        try{
            int data =  vehicleMapper.insert(vehicle);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(Vehicle vehicle){
        try{
            int data =  vehicleMapper.update(vehicle);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto delete(int id){
        try{
            int data =  vehicleMapper.delete(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        }catch (Exception e){
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
