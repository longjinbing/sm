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
import com.ljb.entity.ShopOrderDetails;
import com.ljb.service.ShopOrderDetailsService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 订单详情Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 17:06:39
 */
@RestController
@RequestMapping("shoporderdetails")
@Desc(group="商城中心",name="订单详情",type=1,url="shop/shoporderdetails.html")
public class ShopOrderDetailsController extends AbstractController {
    @Autowired
    private ShopOrderDetailsService shopOrderDetailsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shoporderdetails:list")
    @Desc(name="订单详情列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopOrderDetailsService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shoporderdetails:info")
    @Desc(name="查看订单详情",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopOrderDetails shopOrderDetails = shopOrderDetailsService.queryObject(id);

        return R.ok().put("shopOrderDetails", shopOrderDetails);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shoporderdetails:details")
    @Desc(name="查看订单详情详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopOrderDetails = shopOrderDetailsService.queryDetails(id);

        return R.ok().put("shopOrderDetails", shopOrderDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shoporderdetails:save")
    @Desc(name="添加订单详情",type=2)
    public R save(@RequestBody ShopOrderDetails shopOrderDetails) {
        shopOrderDetailsService.save(shopOrderDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shoporderdetails:update")
    @Desc(name="修改订单详情",type=2)
    public R update(@RequestBody ShopOrderDetails shopOrderDetails) {
        shopOrderDetailsService.update(shopOrderDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shoporderdetails:delete")
    @Desc(name="删除订单详情",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopOrderDetailsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="订单详情导出",type=2)
    @RequiresPermissions("shoporderdetails:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopOrderDetails> list = shopOrderDetailsService.queryAll(params);

        return R.ok().put("list", list);
    }
}
