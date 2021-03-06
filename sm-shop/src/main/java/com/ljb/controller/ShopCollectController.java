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
import com.ljb.entity.ShopCollect;
import com.ljb.service.ShopCollectService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 用户收藏Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 09:59:38
 */
@RestController
@RequestMapping("shopcollect")
@Desc(group="商城中心",name="用户收藏",type=1,url="shop/shopcollect.html")
public class ShopCollectController extends AbstractController {
    @Autowired
    private ShopCollectService shopCollectService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopcollect:list")
    @Desc(name="用户收藏列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopCollectService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopcollect:info")
    @Desc(name="查看用户收藏",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopCollect shopCollect = shopCollectService.queryObject(id);

        return R.ok().put("shopCollect", shopCollect);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopcollect:details")
    @Desc(name="查看用户收藏详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopCollect = shopCollectService.queryDetails(id);

        return R.ok().put("shopCollect", shopCollect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopcollect:save")
    @Desc(name="添加用户收藏",type=2)
    public R save(@RequestBody ShopCollect shopCollect) {
        shopCollectService.save(shopCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopcollect:update")
    @Desc(name="修改用户收藏",type=2)
    public R update(@RequestBody ShopCollect shopCollect) {
        shopCollectService.update(shopCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopcollect:delete")
    @Desc(name="删除用户收藏",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopCollectService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="用户收藏导出",type=2)
    @RequiresPermissions("shopcollect:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopCollect> list = shopCollectService.queryAll(params);

        return R.ok().put("list", list);
    }
}
