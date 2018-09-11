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
import com.ljb.entity.CmsCatogry;
import com.ljb.service.CmsCatogryService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 目录Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@RestController
@RequestMapping("cmscatogry")
@Desc(group="文章中心",name="目录",type=1,url="cms/cmscatogry.html")
public class CmsCatogryController extends AbstractController {
    @Autowired
    private CmsCatogryService cmsCatogryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmscatogry:list")
    @Desc(name="目录列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", cmsCatogryService.queryList(params));
    }
    
    @RequestMapping("/ztreelist")
    @RequiresPermissions("cmscatogry:list")
    @Desc(name="目录列表",type=2)
    public R zTreeList() {
        //查询列表数据
        return R.ok().put("selectlist", cmsCatogryService.zTressList());
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmscatogry:info")
    @Desc(name="查看目录",type=2)
    public R info(@PathVariable("id") Integer id) {
        CmsCatogry cmsCatogry = cmsCatogryService.queryObject(id);

        return R.ok().put("cmsCatogry", cmsCatogry);
    }
    

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmscatogry:save")
    @Desc(name="添加目录",type=2)
    public R save(@RequestBody CmsCatogry cmsCatogry) {
        cmsCatogryService.save(cmsCatogry);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmscatogry:update")
    @Desc(name="修改目录",type=2)
    public R update(@RequestBody CmsCatogry cmsCatogry) {
        cmsCatogryService.update(cmsCatogry);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmscatogry:delete")
    @Desc(name="删除目录",type=2)
    public R delete(@RequestBody Integer[]ids) {
        cmsCatogryService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="目录导出",type=2)
    @RequiresPermissions("cmscatogry:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsCatogry> list = cmsCatogryService.queryAll(params);

        return R.ok().put("list", list);
    }
}
