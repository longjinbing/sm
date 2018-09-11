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
import com.ljb.entity.ConstiutionQuestion;
import com.ljb.service.ConstiutionQuestionService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 体质测试问题Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@RestController
@RequestMapping("constiutionquestion")
@Desc(group="体质中心",name="体质测试问题",type=1,url="constitution/constiutionquestion.html")
public class ConstiutionQuestionController extends AbstractController {
    @Autowired
    private ConstiutionQuestionService constiutionQuestionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("constiutionquestion:list")
    @Desc(name="体质测试问题列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", constiutionQuestionService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("constiutionquestion:info")
    @Desc(name="查看体质测试问题",type=2)
    public R info(@PathVariable("id") Integer id) {
        ConstiutionQuestion constiutionQuestion = constiutionQuestionService.queryObject(id);

        return R.ok().put("constiutionQuestion", constiutionQuestion);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("constiutionquestion:details")
    @Desc(name="查看体质测试问题详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> constiutionQuestion = constiutionQuestionService.queryDetails(id);

        return R.ok().put("constiutionQuestion", constiutionQuestion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("constiutionquestion:save")
    @Desc(name="添加体质测试问题",type=2)
    public R save(@RequestBody ConstiutionQuestion constiutionQuestion) {
        constiutionQuestionService.save(constiutionQuestion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("constiutionquestion:update")
    @Desc(name="修改体质测试问题",type=2)
    public R update(@RequestBody ConstiutionQuestion constiutionQuestion) {
        constiutionQuestionService.update(constiutionQuestion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("constiutionquestion:delete")
    @Desc(name="删除体质测试问题",type=2)
    public R delete(@RequestBody Integer[]ids) {
        constiutionQuestionService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ConstiutionQuestion> list = constiutionQuestionService.queryAll(params);

        return R.ok().put("list", list);
    }
}
