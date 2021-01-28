package com.pim.modules.biz.service.impl;






import com.pim.annotation.DataSource;
import com.pim.modules.biz.dao.SysUserDao;
import com.pim.modules.biz.entity.SysUserEntity;
import com.pim.modules.biz.service.SysUserService;
import com.pim.utils.PageUtils;
import com.pim.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;








@Service("sysUserService")
        @DataSource("slave1")
    public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserEntity> page = this.page(new Query<SysUserEntity>().getPage(params), new QueryWrapper<SysUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer saveSysUser(SysUserEntity sysUserEntity) {
        return sysUserDao.saveSysUser(sysUserEntity);
    }

    @Override
    public Integer updateSysUser(SysUserEntity sysUserEntity) {
        return sysUserDao.updateSysUser(sysUserEntity);
    }
}