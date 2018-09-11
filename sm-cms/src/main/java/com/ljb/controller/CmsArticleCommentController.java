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
import com.ljb.entity.CmsArticleComment;
import com.ljb.service.CmsArticleCommentService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 文章评论Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@RestController
@RequestMapping("cmsarticlecomment")
@Desc(group="文章中心",name="文章评论",type=1,url="cms/cmsarticlecomment.html")
public class CmsArticleCommentController extends AbstractController {
    @Autowired
    private CmsArticleCommentService cmsArticleCommentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cmsarticlecomment:list")
    @Desc(name="文章评论列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", cmsArticleCommentService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("cmsarticlecomment:info")
    @Desc(name="查看文章评论",type=2)
    public R info(@PathVariable("id") Integer id) {
        CmsArticleComment cmsArticleComment = cmsArticleCommentService.queryObject(id);

        return R.ok().put("cmsArticleComment", cmsArticleComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cmsarticlecomment:save")
    @Desc(name="添加文章评论",type=2)
    public R save(@RequestBody CmsArticleComment cmsArticleComment) {
        cmsArticleCommentService.save(cmsArticleComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cmsarticlecomment:update")
    @Desc(name="修改文章评论",type=2)
    public R update(@RequestBody CmsArticleComment cmsArticleComment) {
        cmsArticleCommentService.update(cmsArticleComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cmsarticlecomment:delete")
    @Desc(name="删除文章评论",type=2)
    public R delete(@RequestBody Integer[]ids) {
        cmsArticleCommentService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="文章评论导出",type=2)
    @RequiresPermissions("cmsarticlecomment:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CmsArticleComment> list = cmsArticleCommentService.queryAll(params);

        return R.ok().put("list", list);
    }
}
