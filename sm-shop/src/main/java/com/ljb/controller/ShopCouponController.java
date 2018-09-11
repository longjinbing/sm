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
import com.ljb.entity.ShopCoupon;
import com.ljb.service.ShopCouponService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 优惠券管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@RestController
@RequestMapping("shopcoupon")
@Desc(group="商城中心",name="优惠券管理",type=1,url="shop/shopcoupon.html")
public class ShopCouponController extends AbstractController {
    @Autowired
    private ShopCouponService shopCouponService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopcoupon:list")
    @Desc(name="优惠券管理列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopCouponService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopcoupon:info")
    @Desc(name="查看优惠券管理",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopCoupon shopCoupon = shopCouponService.queryObject(id);

        return R.ok().put("shopCoupon", shopCoupon);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopcoupon:details")
    @Desc(name="查看优惠券管理详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopCoupon = shopCouponService.queryDetails(id);

        return R.ok().put("shopCoupon", shopCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopcoupon:save")
    @Desc(name="添加优惠券管理",type=2)
    public R save(@RequestBody ShopCoupon shopCoupon) {
        shopCouponService.save(shopCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopcoupon:update")
    @Desc(name="修改优惠券管理",type=2)
    public R update(@RequestBody ShopCoupon shopCoupon) {
        shopCouponService.update(shopCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopcoupon:delete")
    @Desc(name="删除优惠券管理",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopCouponService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="优惠券管理导出",type=2)
    @RequiresPermissions("shopcoupon:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopCoupon> list = shopCouponService.queryAll(params);

        return R.ok().put("list", list);
    }
}
