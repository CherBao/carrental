package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.Vehicle;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/vehicle")
@Api(tags = "车辆管理相关接口")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/query")
    @ApiOperation("查询所有车辆信息接口")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return vehicleService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("根据ID查询车辆信息接口")
    public ResponseDto queryById(@PathVariable int id) {
        return vehicleService.queryById(id);
    }

    @GetMapping(value = "/query/status/{status}")
    @ApiOperation("根据车辆状态查询车辆信息接口")
    public ResponseDto queryByStatus(@PathVariable char status) {
        return vehicleService.queryByStatus(status);
    }

    @PostMapping()
    @ApiOperation("添加车辆接口")
    public ResponseDto add(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.insert(vehicle);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("更新车辆信息接口")
    public ResponseDto update(@Valid @RequestBody Vehicle vehicle, @PathVariable int id) {
        return vehicleService.update(vehicle, id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除车辆接口")
    public ResponseDto delete(@PathVariable int id) {
        return vehicleService.delete(id);
    }
}
