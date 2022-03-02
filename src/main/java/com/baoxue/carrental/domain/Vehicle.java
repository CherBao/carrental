package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel
public class Vehicle {
    @ApiModelProperty(value = "车辆id")
    private int id;

    @ApiModelProperty(value = "车辆型号")
    @NotBlank(message = "车辆型号不能为空")
    @Size(max = 20, message = "车辆型号字段长度超长")
    private String type;

    @ApiModelProperty(value = "车辆状态")
    private char status = '0';

    @ApiModelProperty(value = "车辆预定价格/天")
    private BigDecimal price = BigDecimal.ZERO;
}
