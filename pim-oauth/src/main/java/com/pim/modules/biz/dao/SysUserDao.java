package com.pim.modules.biz.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pim.modules.biz.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 *
 * @author LYF
 * @email 141310datastar@gmail.com
 * @date 2021-01-27 17:19:24
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    /**
     *  SQL方式保存
     * @param sysUserEntity
     * @return
     */
    Integer saveSysUser(SysUserEntity sysUserEntity);

    /**
     *  SQL方式更新
     * @param sysUserEntity
     * @return
     */
    Integer updateSysUser(SysUserEntity sysUserEntity);
}
