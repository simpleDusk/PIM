package com.ps.dao;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ps.vo.TableEntityVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2018-07-24
 */
public interface GeneratorDao {
    IPage<TableEntityVo> queryList(IPage<TableEntityVo> page, @Param("tableName") String tableName);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
