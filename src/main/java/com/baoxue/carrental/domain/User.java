package com.baoxue.carrental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "user id")
    private int id;

    @ApiModelProperty(value = "user name")
    @NotBlank(message = "user name cannot be blank")
    @Size(max = 20, message = "User name is too long")
    private String name;

    @ApiModelProperty(value = "user phone")
    @NotBlank(message = "user phone cannot be blank")
    @Size(min = 11, max = 11, message = "Illegal length of user phone")
    private String phone;

    @ApiModelProperty(value = "user password")
    @NotBlank(message = "user password cannot be blank")
    @Size(min = 8, max = 8, message = "Illegal length of user password")
    private String password;

}
