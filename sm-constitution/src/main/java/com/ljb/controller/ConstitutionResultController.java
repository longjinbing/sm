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
import com.ljb.entity.ConstitutionResult;
import com.ljb.service.ConstitutionResultService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 体质测试结果Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@RestController
@RequestMapping("constitutionresult")
@Desc(group="体质中心",name="体质测试结果",type=1,url="constitution/constitutionresult.html")
public class ConstitutionResultController extends AbstractController {
    @Autowired
    private ConstitutionResultService constitutionResultService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("constitutionresult:list")
    @Desc(name="体质测试结果列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", constitutionResultService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("constitutionresult:info")
    @Desc(name="查看体质测试结果",type=2)
    public R info(@PathVariable("id") Integer id) {
        ConstitutionResult constitutionResult = constitutionResultService.queryObject(id);

        return R.ok().put("constitutionResult", constitutionResult);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("constitutionresult:details")
    @Desc(name="查看体质测试结果详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> constitutionResult = constitutionResultService.queryDetails(id);

        return R.ok().put("constitutionResult", constitutionResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("constitutionresult:save")
    @Desc(name="添加体质测试结果",type=2)
    public R save(@RequestBody ConstitutionResult constitutionResult) {
        constitutionResultService.save(constitutionResult);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("constitutionresult:update")
    @Desc(name="修改体质测试结果",type=2)
    public R update(@RequestBody ConstitutionResult constitutionResult) {
        constitutionResultService.update(constitutionResult);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("constitutionresult:delete")
    @Desc(name="删除体质测试结果",type=2)
    public R delete(@RequestBody Integer[]ids) {
        constitutionResultService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="体质测试结果导出",type=2)
    @RequiresPermissions("constitutionresult:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ConstitutionResult> list = constitutionResultService.queryAll(params);

        return R.ok().put("list", list);
    }
}
