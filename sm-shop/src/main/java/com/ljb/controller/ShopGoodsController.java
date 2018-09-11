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
import com.ljb.entity.ShopGoods;
import com.ljb.service.ShopGoodsService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 商品管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@RestController
@RequestMapping("shopgoods")
@Desc(group="商城中心",name="商品管理",type=1,url="shop/shopgoods.html")
public class ShopGoodsController extends AbstractController {
    @Autowired
    private ShopGoodsService shopGoodsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopgoods:list")
    @Desc(name="商品管理列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopGoodsService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopgoods:info")
    @Desc(name="查看商品管理",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopGoods shopGoods = shopGoodsService.queryObject(id);

        return R.ok().put("shopGoods", shopGoods);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopgoods:details")
    @Desc(name="查看商品管理详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopGoods = shopGoodsService.queryDetails(id);

        return R.ok().put("shopGoods", shopGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopgoods:save")
    @Desc(name="添加商品管理",type=2)
    public R save(@RequestBody ShopGoods shopGoods) {
        shopGoodsService.save(shopGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopgoods:update")
    @Desc(name="修改商品管理",type=2)
    public R update(@RequestBody ShopGoods shopGoods) {
        shopGoodsService.update(shopGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopgoods:delete")
    @Desc(name="删除商品管理",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopGoodsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="商品管理导出",type=2)
    @RequiresPermissions("shopgoods:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopGoods> list = shopGoodsService.queryAll(params);

        return R.ok().put("list", list);
    }
}
