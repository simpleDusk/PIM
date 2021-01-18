package com.ps.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lyf
 */
@Data
@ToString
public class TableEntityVo implements Serializable {

    private static final long serialVersionUID = 4061201850550877858L;

    private String tableName;

    private String engine;

    private String tableComment;

    private Date createTime;
}
