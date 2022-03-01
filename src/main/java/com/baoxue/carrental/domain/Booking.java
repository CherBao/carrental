package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ApiModel
public class Booking {
    @ApiModelProperty(value = "用户id")
    private int userid;
    @ApiModelProperty(value = "车辆id")
    private int vehicleid;
    @ApiModelProperty(value = "预定状态")
    private String status="00";
    @ApiModelProperty(value = "总租金")
    private BigDecimal rent;
    @ApiModelProperty(value = "预定取车日期")
    private Date begdate;
    @ApiModelProperty(value = "租期")
    private int tenancy;
}
