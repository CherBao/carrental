package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@ApiModel
public class Booking {

    @ApiModelProperty(value = "预定单号")
    private String order_no;

    @ApiModelProperty(value = "用户id")
    private int user_id;

    @ApiModelProperty(value = "车辆id")
    private int vehicle_id;

    @ApiModelProperty(value = "预定状态")
    private char status = '0';

    @ApiModelProperty(value = "总租金")
    private BigDecimal rent = BigDecimal.ZERO;

    @ApiModelProperty(value = "预定取车日期")
    @NotNull(message = "预定取车时间不能为空")
    private Timestamp take_date;

    @ApiModelProperty(value = "租期")
    private int tenancy;

    @ApiModelProperty(value = "创建日期")
    private Timestamp create_time;
}
