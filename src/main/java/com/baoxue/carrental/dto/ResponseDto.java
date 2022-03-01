package com.baoxue.carrental.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class ResponseDto {
    @ApiModelProperty(value = "是否成功")
    private boolean isSuccess;
    @ApiModelProperty(value = "详细数据")
    private Object data;
    @ApiModelProperty(value = "描述信息")
    private String message;
}
