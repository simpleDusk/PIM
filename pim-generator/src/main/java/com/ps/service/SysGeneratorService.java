

package com.ps.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ps.annotation.DataSource;
import com.ps.dao.GeneratorDao;
import com.ps.utils.GenUtils;
import com.ps.utils.PageUtils;
import com.ps.utils.Query;
import com.ps.vo.TableEntityVo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
@DataSource("slave1")
public class SysGeneratorService {
    @Autowired
    private GeneratorDao generatorDao;

    public PageUtils queryList(Query query) {
        IPage<TableEntityVo> page = new Page<>(query.getPage(), query.getLimit());
        IPage<TableEntityVo> result = generatorDao.queryList(page, (String) query.get("tableName"));

        return new PageUtils(result);
    }

    public Map<String, String> queryTable(String tableName) {
        return generatorDao.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorDao.queryColumns(tableName);
    }

    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            // 查出用的哪个数据源
            DataSource targetDataSource = this.getClass().getAnnotation(DataSource.class);
            String value = null;
            if(targetDataSource != null){
                value = targetDataSource.value();
            }
            //生成代码
            GenUtils.generatorCode(value,table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
