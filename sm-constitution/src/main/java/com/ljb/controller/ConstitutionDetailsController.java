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
import com.ljb.entity.ConstitutionDetails;
import com.ljb.service.ConstitutionDetailsService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 体质介绍Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:59:04
 */
@RestController
@RequestMapping("constitutiondetails")
@Desc(group="体质中心",name="体质介绍",type=1,url="constitution/constitutiondetails.html")
public class ConstitutionDetailsController extends AbstractController {
    @Autowired
    private ConstitutionDetailsService constitutionDetailsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("constitutiondetails:list")
    @Desc(name="体质介绍列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", constitutionDetailsService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("constitutiondetails:info")
    @Desc(name="查看体质介绍",type=2)
    public R info(@PathVariable("id") Integer id) {
        ConstitutionDetails constitutionDetails = constitutionDetailsService.queryObject(id);

        return R.ok().put("constitutionDetails", constitutionDetails);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("constitutiondetails:details")
    @Desc(name="查看体质介绍详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> constitutionDetails = constitutionDetailsService.queryDetails(id);

        return R.ok().put("constitutionDetails", constitutionDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("constitutiondetails:save")
    @Desc(name="添加体质介绍",type=2)
    public R save(@RequestBody ConstitutionDetails constitutionDetails) {
        constitutionDetailsService.save(constitutionDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("constitutiondetails:update")
    @Desc(name="修改体质介绍",type=2)
    public R update(@RequestBody ConstitutionDetails constitutionDetails) {
        constitutionDetailsService.update(constitutionDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("constitutiondetails:delete")
    @Desc(name="删除体质介绍",type=2)
    public R delete(@RequestBody Integer[]ids) {
        constitutionDetailsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="体质介绍导出",type=2)
    @RequiresPermissions("constitutiondetails:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ConstitutionDetails> list = constitutionDetailsService.queryAll(params);

        return R.ok().put("list", list);
    }
}
