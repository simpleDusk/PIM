package com.pim.modules.biz.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author LYF
 * @email 141310datastar@gmail.com
 * @date 2021-01-27 17:19:24
 */
@Data
@TableName("sys_user" )
@ApiModel("实体类" )
public class SysUserEntity  {
    private static final long serialVersionUID = 1L;

            /**
         * 
         */
                @TableId
            @ApiModelProperty(value = "用户id" , dataType = "Integer" )
    private Integer id;
            /**
         * 
         */
            @ApiModelProperty(value = "用户code" , dataType = "String" )
    private String username;
            /**
         * 
         */
            @ApiModelProperty(value = "用户名称" , dataType = "String" )
    private String realname;
            /**
         * 
         */
            @ApiModelProperty(value = "用户密码" , dataType = "String" )
    private String password;
            /**
         * 
         */
            @ApiModelProperty(value = "创建时间" , dataType = "Date" )
    private Date createdate;
            /**
         * 
         */
            @ApiModelProperty(value = "最后更改时间" , dataType = "Date" )
    private Date lastlogintime;
            /**
         * 
         */
            @ApiModelProperty(value = "是否启用.0启用、1禁用" , dataType = "Integer" )
    private Integer enabled;
            /**
         * 
         */
            @ApiModelProperty(value = "帐户未过期" , dataType = "Integer" )
    private Integer accountnonexpired;
            /**
         * 
         */
            @ApiModelProperty(value = "非锁定帐户" , dataType = "Integer" )
    private Integer accountnonlocked;
            /**
         * 
         */
            @ApiModelProperty(value = "凭证未过期" , dataType = "Integer" )
    private Integer credentialsnonexpired;
    
}
