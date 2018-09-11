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
import com.ljb.entity.SysRoleMenu;
import com.ljb.service.SysRoleMenuService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 角色与菜单Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-02 11:53:00
 */
@RestController
@RequestMapping("sysrolemenu")
@Desc(group="系统设置",name="角色与菜单",type=1,url="admin/sysrolemenu.html")
public class SysRoleMenuController extends AbstractController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysrolemenu:list")
    @Desc(name="角色与菜单列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", sysRoleMenuService.queryList(params));
    }
    
    @RequestMapping("/menulist/{roleId}")
    @RequiresPermissions("sysrolemenu:list")
    public R list(@PathVariable Integer roleId) {
        //查询列表数据
        return R.ok().put("menulist", sysRoleMenuService.menuList(roleId, getSysUserId()));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysrolemenu:info")
    @Desc(name="查看角色与菜单",type=2)
    public R info(@PathVariable("id") Integer id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.queryObject(id);

        return R.ok().put("sysRoleMenu", sysRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysrolemenu:save")
    @Desc(name="添加角色与菜单",type=2)
    public R save(@RequestParam("id") Integer roleId,@RequestParam("menuIds") Integer[] menuIds) {
        sysRoleMenuService.save(roleId,menuIds,getSysUserId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysrolemenu:update")
    @Desc(name="修改角色与菜单",type=2)
    public R update(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.update(sysRoleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysrolemenu:delete")
    @Desc(name="删除角色与菜单",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRoleMenuService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SysRoleMenu> list = sysRoleMenuService.queryAll(params);

        return R.ok().put("list", list);
    }
}
