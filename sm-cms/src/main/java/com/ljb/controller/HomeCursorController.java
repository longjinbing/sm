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
import com.ljb.entity.HomeCursor;
import com.ljb.service.HomeCursorService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 首页轮播Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@RestController
@RequestMapping("homecursor")
@Desc(group="文章中心",name="首页轮播",type=1,url="cms/homecursor.html")
public class HomeCursorController extends AbstractController {
    @Autowired
    private HomeCursorService homeCursorService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("homecursor:list")
    @Desc(name="首页轮播列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", homeCursorService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("homecursor:info")
    @Desc(name="查看首页轮播",type=2)
    public R info(@PathVariable("id") Integer id) {
        HomeCursor homeCursor = homeCursorService.queryObject(id);

        return R.ok().put("homeCursor", homeCursor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("homecursor:save")
    @Desc(name="添加首页轮播",type=2)
    public R save(@RequestBody HomeCursor homeCursor) {
        homeCursorService.save(homeCursor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("homecursor:update")
    @Desc(name="修改首页轮播",type=2)
    public R update(@RequestBody HomeCursor homeCursor) {
        homeCursorService.update(homeCursor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("homecursor:delete")
    @Desc(name="删除首页轮播",type=2)
    public R delete(@RequestBody Integer[]ids) {
        homeCursorService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="首页轮播导出",type=2)
    @RequiresPermissions("homecursor:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<HomeCursor> list = homeCursorService.queryAll(params);

        return R.ok().put("list", list);
    }
}
