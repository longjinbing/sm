package com.ljb.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.ljb.entity.ResultDetails;
import com.ljb.service.ResultDetailsService;
import com.ljb.utils.R;
import com.mysql.fabric.xmlrpc.base.Array;
import com.ljb.annotation.Desc;

/**
 * 体质测试结果详情Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 17:18:14
 */
@RestController
@RequestMapping("resultdetails")
@Desc(group="体质中心",name="体质测试结果详情",type=1,url="constitution/resultdetails.html")
public class ResultDetailsController extends AbstractController {
    @Autowired
    private ResultDetailsService resultDetailsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("resultdetails:list")
    @Desc(name="体质测试结果详情列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", resultDetailsService.queryList(params));
    }
    
    @RequestMapping("/resultdetails/{id}")
    public R resultDeatils(@PathVariable("id") Integer id) {
        //查询列表数据
        return R.ok().put("data", resultDetailsService.resultDetails(id));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("resultdetails:info")
    @Desc(name="查看体质测试结果详情",type=2)
    public R info(@PathVariable("id") Integer id) {
        ResultDetails resultDetails = resultDetailsService.queryObject(id);

        return R.ok().put("resultDetails", resultDetails);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("resultdetails:details")
    @Desc(name="查看体质测试结果详情详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> resultDetails = resultDetailsService.queryDetails(id);

        return R.ok().put("resultDetails", resultDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("resultdetails:save")
    @Desc(name="添加体质测试结果详情",type=2)
    public R save(@RequestBody ResultDetails resultDetails) {
        resultDetailsService.save(resultDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("resultdetails:update")
    @Desc(name="修改体质测试结果详情",type=2)
    public R update(@RequestBody ResultDetails resultDetails) {
        resultDetailsService.update(resultDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("resultdetails:delete")
    @Desc(name="删除体质测试结果详情",type=2)
    public R delete(@RequestBody Integer[]ids) {
        resultDetailsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="体质测试结果详情导出",type=2)
    @RequiresPermissions("resultdetails:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ResultDetails> list = resultDetailsService.queryAll(params);

        return R.ok().put("list", list);
    }
}
