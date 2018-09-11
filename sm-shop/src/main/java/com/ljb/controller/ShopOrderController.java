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
import com.ljb.entity.ShopOrder;
import com.ljb.service.ShopOrderService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 订单管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@RestController
@RequestMapping("shoporder")
@Desc(group="商城中心",name="订单管理",type=1,url="shop/shoporder.html")
public class ShopOrderController extends AbstractController {
    @Autowired
    private ShopOrderService shopOrderService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shoporder:list")
    @Desc(name="订单管理列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopOrderService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shoporder:info")
    @Desc(name="查看订单管理",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopOrder shopOrder = shopOrderService.queryObject(id);

        return R.ok().put("shopOrder", shopOrder);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shoporder:details")
    @Desc(name="查看订单管理详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopOrder = shopOrderService.queryDetails(id);

        return R.ok().put("shopOrder", shopOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shoporder:save")
    @Desc(name="添加订单管理",type=2)
    public R save(@RequestBody ShopOrder shopOrder) {
        shopOrderService.save(shopOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shoporder:update")
    @Desc(name="修改订单管理",type=2)
    public R update(@RequestBody ShopOrder shopOrder) {
        shopOrderService.update(shopOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shoporder:delete")
    @Desc(name="删除订单管理",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopOrderService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="订单管理导出",type=2)
    @RequiresPermissions("shoporder:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopOrder> list = shopOrderService.queryAll(params);

        return R.ok().put("list", list);
    }
}
