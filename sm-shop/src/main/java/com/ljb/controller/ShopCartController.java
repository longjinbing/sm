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
import com.ljb.entity.ShopCart;
import com.ljb.service.ShopCartService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 购物车Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@RestController
@RequestMapping("shopcart")
@Desc(group="商城中心",name="购物车",type=1,url="shop/shopcart.html")
public class ShopCartController extends AbstractController {
    @Autowired
    private ShopCartService shopCartService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopcart:list")
    @Desc(name="购物车列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopCartService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopcart:info")
    @Desc(name="查看购物车",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopCart shopCart = shopCartService.queryObject(id);

        return R.ok().put("shopCart", shopCart);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopcart:details")
    @Desc(name="查看购物车详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopCart = shopCartService.queryDetails(id);

        return R.ok().put("shopCart", shopCart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopcart:save")
    @Desc(name="添加购物车",type=2)
    public R save(@RequestBody ShopCart shopCart) {
        shopCartService.save(shopCart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopcart:update")
    @Desc(name="修改购物车",type=2)
    public R update(@RequestBody ShopCart shopCart) {
        shopCartService.update(shopCart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopcart:delete")
    @Desc(name="删除购物车",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopCartService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="购物车导出",type=2)
    @RequiresPermissions("shopcart:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopCart> list = shopCartService.queryAll(params);

        return R.ok().put("list", list);
    }
}
