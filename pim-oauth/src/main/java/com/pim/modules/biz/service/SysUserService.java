package com.pim.modules.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pim.modules.biz.entity.SysUserEntity;
import com.pim.utils.PageUtils;


import java.util.Map;

/**
 * 
 *
 * @author LYF
 * @email 141310datastar@gmail.com
 * @date 2021-01-27 17:19:24
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer saveSysUser(SysUserEntity sysUserEntity);

    Integer updateSysUser(SysUserEntity sysUserEntity);
}

