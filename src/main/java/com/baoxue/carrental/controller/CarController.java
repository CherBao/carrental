package com.baoxue.carrental.controller;

import com.baoxue.carrental.domain.Car;
import com.baoxue.carrental.dto.ResponseDto;
import com.baoxue.carrental.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/car")
@Api(tags = "Car management related interfaces")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/query")
    @ApiOperation("Paging query all car information interfaces")
    public ResponseDto queryAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return carService.queryAll(offset, limit);
    }

    @GetMapping(value = "/query/{id}")
    @ApiOperation("Query car information interface according to ID")
    public ResponseDto queryById(@PathVariable String id) {
        return carService.queryById(id);
    }

    @GetMapping(value = "/query/models")
    @ApiOperation("Query all car models and stock")
    public ResponseDto queryCarModelsWithStock() {
        return carService.queryCarModelsWithStock();
    }

    @GetMapping(value = "/query/stock/{model}")
    @ApiOperation("Query all car in stock according to model")
    public ResponseDto queryStockByModel(@PathVariable String model) {
        return carService.queryStockByModel(model);
    }

    @PostMapping()
    @ApiOperation("Add car interface")
    public ResponseDto add(@Valid @RequestBody Car car) {
        return carService.insert(car);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Update car information interface")
    public ResponseDto update(@Valid @RequestBody Car car, @PathVariable String id) {
        return carService.update(car, id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Delete car interface")
    public ResponseDto delete(@PathVariable String id) {
        return carService.delete(id);
    }
}
