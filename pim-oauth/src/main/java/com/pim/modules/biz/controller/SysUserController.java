package com.pim.modules.biz.controller;

import java.util.Arrays;
import java.util.Map;


import com.pim.modules.biz.entity.SysUserEntity;
import com.pim.modules.biz.service.SysUserService;
import com.pim.utils.PageUtils;
import com.pim.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * 
 *
 * @author LYF
 * @email 141310datastar@gmail.com
 * @date 2021-01-27 17:19:24
 */
@Api(value = "API",tags = {"用户权限API"})
@RestController
@RequestMapping("biz/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @ApiOperation(value = "用户-获取列表（分页）",httpMethod = "GET")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "用户-获取详细信息",httpMethod = "GET")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SysUserEntity sysUser = sysUserService.getById(id);

        return R.ok().put("sysUser", sysUser);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "用户-保存",httpMethod = "POST")
    @RequestMapping("/save")
    public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "用户-更新",httpMethod = "POST")
    @RequestMapping("/update")
    public R update(@RequestBody SysUserEntity sysUser){
		sysUserService.updateById(sysUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "用户-删除",httpMethod = "POST")
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		sysUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
