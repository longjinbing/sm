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
import com.ljb.entity.Token;
import com.ljb.service.TokenService;
import com.ljb.utils.R;
import com.ljb.annotation.Desc;

/**
 * 用户TokenController
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-02 11:53:01
 */
@RestController
@RequestMapping("token")
@Desc(group="系统设置",name="用户Token",type=1,url="admin/token.html")
public class TokenController extends AbstractController {
    @Autowired
    private TokenService tokenService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("token:list")
    @Desc(name="用户Token列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", tokenService.queryList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("token:info")
    @Desc(name="查看用户Token",type=2)
    public R info(@PathVariable("userId") Integer userId) {
        Token token = tokenService.queryObject(userId);

        return R.ok().put("token", token);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("token:save")
    @Desc(name="添加用户Token",type=2)
    public R save(@RequestBody Token token) {
        tokenService.save(token);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("token:update")
    @Desc(name="修改用户Token",type=2)
    public R update(@RequestBody Token token) {
        tokenService.update(token);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("token:delete")
    @Desc(name="删除用户Token",type=2)
    public R delete(@RequestBody Integer[]userIds) {
        tokenService.deleteBatch(userIds);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Token> list = tokenService.queryAll(params);

        return R.ok().put("list", list);
    }
}
