package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "用户id")
    private int id;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "用户电话")
    private String phone;
}
