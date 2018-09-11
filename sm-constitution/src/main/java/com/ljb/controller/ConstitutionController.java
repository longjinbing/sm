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
import com.ljb.entity.Constitution;
import com.ljb.service.ConstitutionService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 体质管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@RestController
@RequestMapping("constitution")
@Desc(group="体质中心",name="体质管理",type=1,url="constitution/constitution.html")
public class ConstitutionController extends AbstractController {
    @Autowired
    private ConstitutionService constitutionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("constitution:list")
    @Desc(name="体质管理列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", constitutionService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("constitution:info")
    @Desc(name="查看体质管理",type=2)
    public R info(@PathVariable("id") Integer id) {
        Constitution constitution = constitutionService.queryObject(id);

        return R.ok().put("constitution", constitution);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("constitution:details")
    @Desc(name="查看体质管理详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> constitution = constitutionService.queryDetails(id);

        return R.ok().put("constitution", constitution);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("constitution:save")
    @Desc(name="添加体质管理",type=2)
    public R save(@RequestBody Constitution constitution) {
        constitutionService.save(constitution);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("constitution:update")
    @Desc(name="修改体质管理",type=2)
    public R update(@RequestBody Constitution constitution) {
        constitutionService.update(constitution);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("constitution:delete")
    @Desc(name="删除体质管理",type=2)
    public R delete(@RequestBody Integer[]ids) {
        constitutionService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="体质管理导出",type=2)
    @RequiresPermissions("constitution:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Constitution> list = constitutionService.queryAll(params);

        return R.ok().put("list", list);
    }
}
