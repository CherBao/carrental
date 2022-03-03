package com.baoxue.carrental.service;

import com.baoxue.carrental.domain.Car;
import com.baoxue.carrental.dto.CarModelStockDto;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.mapper.CarMapper;
import com.baoxue.carrental.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public ResponseDto queryAll(int offset, int limit) {
        try {
            if (offset < 0 || limit <= 0) throw new Exception("Illegal paging parameter!");
            List<Car> data = carMapper.queryAll(offset, limit);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryById(String id) {
        try {
            Car data = carMapper.queryById(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto queryCarModelsWithStock() {
        try {
            List<CarModelStockDto> data = carMapper.queryCarModels();
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
    public ResponseDto queryStockByModel(String model) {
        try {
            List<Car> data = carMapper.queryStockByModel(model);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
    public ResponseDto insert(Car car) {
        try {
            car.setStatus(Constants.CAR_IN_STOCK);
            int data = carMapper.insert(car);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto update(Car car, String id) {
        try {
            int data = carMapper.update(car, id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }

    public ResponseDto delete(String id) {
        try {
            int data = carMapper.delete(id);
            return ResponseDto.builder().isSuccess(true).data(data).message("ok").build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseDto.builder().isSuccess(false).message(e.getMessage()).build();
        }
    }
}
