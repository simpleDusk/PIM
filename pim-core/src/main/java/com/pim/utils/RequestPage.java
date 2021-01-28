package com.pim.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author admin
 */
@ApiModel("通用分页请求对象")
@Data
@ToString
public class RequestPage implements Serializable {

    private static final long serialVersionUID = 4688108948248193288L;

    @ApiModelProperty(value = "当前页码", example = "1",dataType = "String")
    private String page;

    @ApiModelProperty(value = "每页显示记录数", example = "10",dataType = "String")
    private String limit;
}
