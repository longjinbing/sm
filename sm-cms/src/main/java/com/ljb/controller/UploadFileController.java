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
import com.ljb.entity.UploadFile;
import com.ljb.service.UploadFileService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 上传文件Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@RestController
@RequestMapping("uploadfile")
@Desc(group="文章中心",name="上传文件",type=1,url="cms/uploadfile.html")
public class UploadFileController extends AbstractController {
    @Autowired
    private UploadFileService uploadFileService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("uploadfile:list")
    @Desc(name="上传文件列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", uploadFileService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("uploadfile:info")
    @Desc(name="查看上传文件",type=2)
    public R info(@PathVariable("id") Integer id) {
        UploadFile uploadFile = uploadFileService.queryObject(id);

        return R.ok().put("uploadFile", uploadFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("uploadfile:save")
    @Desc(name="添加上传文件",type=2)
    public R save(@RequestBody UploadFile uploadFile) {
        uploadFileService.save(uploadFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("uploadfile:update")
    @Desc(name="修改上传文件",type=2)
    public R update(@RequestBody UploadFile uploadFile) {
        uploadFileService.update(uploadFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("uploadfile:delete")
    @Desc(name="删除上传文件",type=2)
    public R delete(@RequestBody Integer[]ids) {
        uploadFileService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="上传文件导出",type=2)
    @RequiresPermissions("uploadfile:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<UploadFile> list = uploadFileService.queryAll(params);

        return R.ok().put("list", list);
    }
}
