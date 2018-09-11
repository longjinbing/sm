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
import com.ljb.entity.ShopAddress;
import com.ljb.service.ShopAddressService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 用户地址Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@RestController
@RequestMapping("shopaddress")
@Desc(group="商城中心",name="用户地址",type=1,url="shop/shopaddress.html")
public class ShopAddressController extends AbstractController {
    @Autowired
    private ShopAddressService shopAddressService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shopaddress:list")
    @Desc(name="用户地址列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", shopAddressService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shopaddress:info")
    @Desc(name="查看用户地址",type=2)
    public R info(@PathVariable("id") Integer id) {
        ShopAddress shopAddress = shopAddressService.queryObject(id);

        return R.ok().put("shopAddress", shopAddress);
    }
    
     /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @RequiresPermissions("shopaddress:details")
    @Desc(name="查看用户地址详细信息",type=2)
    public R details(@PathVariable("id") Integer id) {
        Map<String, Object> shopAddress = shopAddressService.queryDetails(id);

        return R.ok().put("shopAddress", shopAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shopaddress:save")
    @Desc(name="添加用户地址",type=2)
    public R save(@RequestBody ShopAddress shopAddress) {
        shopAddressService.save(shopAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shopaddress:update")
    @Desc(name="修改用户地址",type=2)
    public R update(@RequestBody ShopAddress shopAddress) {
        shopAddressService.update(shopAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shopaddress:delete")
    @Desc(name="删除用户地址",type=2)
    public R delete(@RequestBody Integer[]ids) {
        shopAddressService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @Desc(name="用户地址导出",type=2)
    @RequiresPermissions("shopaddress:export")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ShopAddress> list = shopAddressService.queryAll(params);

        return R.ok().put("list", list);
    }
}
