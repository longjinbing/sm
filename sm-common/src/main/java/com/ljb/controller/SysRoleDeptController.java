package com.ljb.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysRoleDept;
import com.ljb.service.SysRoleDeptService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 角色与部门对应关系Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-02 11:53:01
 */
@RestController
@RequestMapping("sysroledept")
@Desc(group="系统设置",name="角色与部门对应关系",type=1,url="admin/sysroledept.html")
public class SysRoleDeptController extends AbstractController {
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysroledept:list")
    @Desc(name="角色与部门对应关系列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", sysRoleDeptService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysroledept:info")
    @Desc(name="查看角色与部门对应关系",type=2)
    public R info(@PathVariable("id") Integer id) {
        SysRoleDept sysRoleDept = sysRoleDeptService.queryObject(id);

        return R.ok().put("sysRoleDept", sysRoleDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysroledept:save")
    @Desc(name="添加角色与部门对应关系",type=2)
    public R save(@RequestBody SysRoleDept sysRoleDept) {
        sysRoleDeptService.save(sysRoleDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysroledept:update")
    @Desc(name="修改角色与部门对应关系",type=2)
    public R update(@RequestBody SysRoleDept sysRoleDept) {
        sysRoleDeptService.update(sysRoleDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysroledept:delete")
    @Desc(name="删除角色与部门对应关系",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRoleDeptService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SysRoleDept> list = sysRoleDeptService.queryAll(params);

        return R.ok().put("list", list);
    }
}
