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
import com.ljb.entity.ShopCategory;
import com.ljb.service.ShopCategoryService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 商品分类Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@RestController
@RequestMapping("shopcategory")
@Desc(group="商城中心",name="商品分类",type=1,url="shop/shopcategory.html")
public class ShopCategoryController extends AbstractController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopcategory:list")
    @Desc(name="商品分类列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopCategoryService.queryList(params));
    }
    
    @RequestMapping("/ztreelist")
    @RequiresPermissions("shopcatogry:list")
    @Desc(name="目录列表",type=2)
    public R zTreeList() {
        //查询列表数据
        return R.ok().put("selectlist", shopCategoryService.zTressList());
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopcategory:info")
    @Desc(name="查看商品分类",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopCategory shopCategory = shopCategoryService.queryObject(id);

        return R.ok().put("shopCategory", shopCategory);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopcategory:details")
    @Desc(name="查看商品分类详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopCategory = shopCategoryService.queryDetails(id);

        return R.ok().put("shopCategory", shopCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopcategory:save")
    @Desc(name="添加商品分类",type=2)
    public R save(@RequestBody ShopCategory shopCategory) {
        shopCategoryService.save(shopCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopcategory:update")
    @Desc(name="修改商品分类",type=2)
    public R update(@RequestBody ShopCategory shopCategory) {
        shopCategoryService.update(shopCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopcategory:delete")
    @Desc(name="删除商品分类",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopCategoryService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="商品分类导出",type=2)
    @RequiresPermissions("shopcategory:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopCategory> list = shopCategoryService.queryAll(params);

        return R.ok().put("list", list);
    }
}
