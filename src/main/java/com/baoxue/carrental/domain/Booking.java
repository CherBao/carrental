package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel
public class Booking {

    @ApiModelProperty(value = "booking order no")
    private String order_no;

    @ApiModelProperty(value = "user id")
    private int user_id;

    @ApiModelProperty(value = "car id")
    private String car_id;

    @ApiModelProperty(value = "booking status")
    private char status = '0';

    @ApiModelProperty(value = "total rent")
    private BigDecimal rent = BigDecimal.ZERO;

    @ApiModelProperty(value = "pick up the car date")
    @NotNull(message = "pickup_date cannot be null")
    private Timestamp pickup_date;

    @ApiModelProperty(value = "return the car date")
    @NotNull(message = "return_date cannot be null")
    private Timestamp return_date;

    @ApiModelProperty(value = "create time")
    private Timestamp create_time;
}
