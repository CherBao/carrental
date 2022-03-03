package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel
public class Car {
    @ApiModelProperty(value = "car id")
    private String id;

    @ApiModelProperty(value = "car model")
    @NotBlank(message = "car model cannot be blank")
    @Size(max = 30, message = "model is too long")
    private String model;

    @ApiModelProperty(value = "car status")
    private char status = '0';

    @ApiModelProperty(value = "car booking price per day")
    private BigDecimal price = BigDecimal.ZERO;
}
