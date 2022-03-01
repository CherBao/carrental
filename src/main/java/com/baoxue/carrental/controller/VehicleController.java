package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.Vehicle;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@Api(tags = "车辆管理相关接口")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有车辆信息接口")
    public ResponseDto queryAll() {
        return vehicleService.queryAll();
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("根据ID查询车辆信息接口")
    public ResponseDto queryById(@PathVariable int id) {
        return vehicleService.queryById(id);
    }

    @GetMapping(value = "/query/status/{status}")
    @ApiOperation("根据车辆状态查询车辆信息接口")
    public ResponseDto queryByStatus(@PathVariable String status) {
        return vehicleService.queryByStatus(status);
    }

    @PostMapping(value = "/add")
    @ApiOperation("添加车辆接口")
    public ResponseDto add(@RequestBody Vehicle vehicle) {
        return vehicleService.insert(vehicle);
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新车辆信息接口")
    public ResponseDto update(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation("删除车辆接口")
    public ResponseDto delete(@PathVariable int id) {
        return vehicleService.delete(id);
    }
}
