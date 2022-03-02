package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "用户id")
    private int id;

    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "用户姓名不能为空")
    @Size(max = 20, message = "用户姓名超长")
    private String name;

    @ApiModelProperty(value = "用户电话")
    @NotBlank(message = "用户电话不能为空")
    @Size(min = 11, max = 11, message = "用户电话长度非法")
    private String phone;
}
