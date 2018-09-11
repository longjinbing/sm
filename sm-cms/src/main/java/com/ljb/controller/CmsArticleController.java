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
import com.ljb.entity.CmsArticle;
import com.ljb.service.CmsArticleService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 文章管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:38:45
 */
@RestController
@RequestMapping("cmsarticle")
@Desc(group="文章中心",name="文章管理",type=1,url="cms/cmsarticle.html")
public class CmsArticleController extends AbstractController {
    @Autowired
    private CmsArticleService cmsArticleService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmsarticle:list")
    @Desc(name="文章管理列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", cmsArticleService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmsarticle:info")
    @Desc(name="查看文章管理",type=2)
    public R info(@PathVariable("id") Integer id) {
        CmsArticle cmsArticle = cmsArticleService.queryObject(id);

        return R.ok().put("cmsArticle", cmsArticle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmsarticle:save")
    @Desc(name="添加文章管理",type=2)
    public R save(@RequestBody CmsArticle cmsArticle) {
        cmsArticleService.save(cmsArticle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmsarticle:update")
    @Desc(name="修改文章管理",type=2)
    public R update(@RequestBody CmsArticle cmsArticle) {
        cmsArticleService.update(cmsArticle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmsarticle:delete")
    @Desc(name="删除文章管理",type=2)
    public R delete(@RequestBody Integer[]ids) {
        cmsArticleService.deleteBatch(ids);

        return R.ok();
    }
    @RequestMapping("/issue")
    @RequiresPermissions("cmsarticle:issue")
    @Desc(name="发布文章",type=2)
    public R issue(@RequestBody Integer[]ids) {
        cmsArticleService.issue(ids);
        return R.ok();
    }
    
    @RequestMapping("/pause")
    @RequiresPermissions("cmsarticle:pause")
    @Desc(name="暂存",type=2)
    public R pause(@RequestBody Integer[]ids) {
        cmsArticleService.pause(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="文章管理导出",type=2)
    @RequiresPermissions("cmsarticle:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsArticle> list = cmsArticleService.queryAll(params);

        return R.ok().put("list", list);
    }
}
