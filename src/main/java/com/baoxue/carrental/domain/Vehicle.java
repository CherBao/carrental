package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class Vehicle {
    @ApiModelProperty(value = "车辆id")
    private int id;
    @ApiModelProperty(value = "车辆型号")
    private String type;
    @ApiModelProperty(value = "车辆状态")
    private String status="00";
    @ApiModelProperty(value = "车辆预定价格/天")
    private BigDecimal price;
}
