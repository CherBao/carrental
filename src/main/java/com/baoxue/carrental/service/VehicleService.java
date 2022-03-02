package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Vehicle;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.VehicleMapper;
import com.baoxue.carrental.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;

    public ResponseDto queryAll(int offset, int limit) {
        try {
            if (offset < 0 || limit <= 0) throw new Exception("分页参数非法!");
            List<Vehicle> data = vehicleMapper.queryAll(offset, limit);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryById(int id) {
        try {
            Vehicle data = vehicleMapper.queryById(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryByStatus(char status) {
        try {
            List<Vehicle> data = vehicleMapper.queryByStatus(status);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto insert(Vehicle vehicle) {
        try {
            vehicle.setStatus(Constants.VEHICLE_IDLE);
            int data = vehicleMapper.insert(vehicle);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(Vehicle vehicle, int id) {
        try {
            int data = vehicleMapper.update(vehicle, id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto delete(int id) {
        try {
            int data = vehicleMapper.delete(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
