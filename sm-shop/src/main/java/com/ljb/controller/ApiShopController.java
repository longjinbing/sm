package com.ljb.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljb.annotation.Desc;
import com.ljb.entity.ShopCart;
import com.ljb.entity.ShopCollect;
import com.ljb.entity.ShopUserCoupon;
import com.ljb.entity.SysUser;
import com.ljb.service.ShopCartService;
import com.ljb.service.ShopCollectService;
import com.ljb.service.ShopCouponService;
import com.ljb.service.ShopGoodsService;
import com.ljb.service.ShopOrderService;
import com.ljb.service.ShopUserCouponService;
import com.ljb.service.SysUserService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;
import com.ljb.utils.SHA256Util;

@Controller
@RequestMapping("api/shop")
public class ApiShopController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private ShopGoodsService shopGoodsService;

	@Autowired
	private ShopCartService shopCartService;

	@Autowired
	private ShopCollectService shopCollectService;

	@Autowired
	private ShopCouponService shopCouponService;

	@Autowired
	private ShopUserCouponService shopUserCouponService;

	@Autowired
	private ShopOrderService shopOrderService;

	// 根据体质搜索相关商品
	@RequestMapping("/goodslistbyconstiution")
	public @ResponseBody R listBy(@RequestParam Map<String, Object> params) {
		
		return R.ok().put("list", shopGoodsService.queryListByConstitution(params));
	}

	// 商品列表
	@RequestMapping("/goodslist")
	public @ResponseBody R list(@RequestParam Map<String, Object> params) {
		
		return R.ok().put("list", shopGoodsService.queryListBy(params));
	}
	
	@RequestMapping("/goodslist/{id}")
	public @ResponseBody R listByCategory(@PathVariable("id") Integer id) {
		
		return R.ok().put("list", shopGoodsService.queryListByCategory(id));
	}
	
	@RequestMapping("/goodslistbyids")
	public @ResponseBody R listByCategoryByIds(@RequestParam("ids") Integer[] ids) {
		
		return R.ok().put("list", shopGoodsService.queryListByCategoryIds(ids));
	}

	// 添加到购物车
	@RequestMapping("/addgoodstocart/{id}")
	public @ResponseBody R addGoodsToCart(@PathVariable("id") Integer id) {
		
		if (!shopCartService.addGoodsToCart(id, getSysUserId()))
			return R.error(-1, "失败");
		return R.ok("添加成功");
	}

	// 立即下单
	@RequestMapping("/ordergoods/{id}")
	public String orderGoods(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("id", id);
		return "android/order.html";
	}

	// 购物车列表
	@RequestMapping("/cartlist")
	public @ResponseBody R cartList() {
		return R.ok("成功").put("list", shopCartService.queryCart(getSysUserId()));
	}

	// 购物车删除商品
	@RequestMapping("/cartremove/{id}")
	public @ResponseBody R cartRemove(@PathVariable("id") Integer id) {
		if (shopCartService.delete(id) == 0) {
			return R.error(-1, "失败");
		}
		return R.ok("成功");
	}

	// 购物车减少商品数量
	@RequestMapping("/cartsub/{id}")
	public @ResponseBody R cartSub(@PathVariable("id") Integer id) {
		ShopCart shopCart = shopCartService.queryObject(id);
		shopCart.setNumber(shopCart.getNumber() > 1 ? shopCart.getNumber() - 1 : shopCart.getNumber());
		shopCartService.update(shopCart);
		return R.ok("成功");
	}

	// 购物车增驾商品数量
	@RequestMapping("/cartadd/{id}")
	public @ResponseBody R cartAdd(@PathVariable("id") Integer id) {
		ShopCart shopCart = shopCartService.queryObject(id);
		shopCart.setNumber(shopCart.getNumber() + 1);
		shopCartService.update(shopCart);
		return R.ok("成功");
	}

	// 确认立即订单
	@RequestMapping("/order")
	public @ResponseBody R order(@RequestParam Map<String, Object> params, Model model) {
		
		if (!shopOrderService.submitOrder(params, Integer.valueOf(params.get("id").toString()), getSysUserId())) {
			return R.error(-1, "失败");
		}
		return R.ok("成功");
	}

	// 确认购物车订单
	@RequestMapping("/orderbycart")
	public @ResponseBody R orderByCart(@RequestParam Map<String, Object> params) {
		
		if (!shopOrderService.submitOrder(params, getSysUserId())) {
			return R.error(-1, "失败");
		}
		return R.ok("成功");
	}

	// 优惠券列表
	@RequestMapping("/couponlist")
	public @ResponseBody R couponList() {
		
		return R.ok().put("page", shopCouponService.queryAll(getSysUserId()));
	}

	@RequestMapping("/couponadd/{id}")
	public @ResponseBody R couponAdd(@PathVariable("id") Integer id) {
		
		ShopUserCoupon shopUserCoupon = new ShopUserCoupon();
		shopUserCoupon.setUserId(getSysUserId());
		shopUserCoupon.setCouponId(id);
		if (shopUserCouponService.save(shopUserCoupon) != 1) {
			return R.error(-1, "网络繁忙,领取失败");
		}
		return R.ok("领取成功");
	}
	
	@RequestMapping("/collectadd/{id}")
	public @ResponseBody R collectAdd(@PathVariable("id") Integer id) {
		
		ShopCollect shopCollect=new ShopCollect();
		shopCollect.setUserId(getSysUserId());
		shopCollect.setGoodsId(id);
		if (shopCollectService.save(shopCollect) != 1) {
			return R.error(-1, "网络繁忙,添加失败");
		}
		return R.ok("添加成功");
	}
	
	

	// 商品收藏
	@RequestMapping("/collectlist")
	public @ResponseBody R collect() {
		
		return R.ok().put("list", shopCollectService.queryListByUserId(getSysUserId()));
	}

	// 收藏夹删除商品
	@RequestMapping("/collectremove/{id}")
	public @ResponseBody R collectRemove(@PathVariable("id") Integer id) {
		;
		if (shopCollectService.delete(id) == 0) {
			return R.error(-1, "失败");
		}
		;
		return R.ok("成功");
	}

	// 根据商品id查找商品ID
	@RequestMapping("/goods/{id}")
	public @ResponseBody R goods(@PathVariable("id") Integer id) {
		
		return R.ok().put("data", shopGoodsService.queryDetails(id));
	}

	@RequestMapping("/goodsdetails/{id}")
	public String goodsDetails(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("id", id);
		return "/android/goodsdetails.html";
	}

	@RequestMapping("/orderlist")
	public @ResponseBody R orderLits() {
		
		return R.ok().put("list", shopOrderService.orderList(getSysUserId()));
	}
	
	@RequestMapping("/order/{id}")
	public String orderDetails(@PathVariable Integer id,Model model) {
		model.addAttribute("id", id);
		return "/android/orderdetails.html";
	}

	@RequestMapping("/orderdetails/{id}")
	public @ResponseBody R orderLits(@PathVariable Integer id) {
		
		return R.ok().put("data", shopOrderService.orderDetails(id));
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody R Login(@RequestParam("username") String username,@RequestParam("password") String password) {
		Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, SHA256Util.getSHA256Str(password));
        token.setRememberMe(true);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return R.error("用户名或密码错误");
        } catch (IncorrectCredentialsException e) {
            return R.error("用户名或密码错误");
        } catch (LockedAccountException lae ) { 
        	return R.error("账户已锁定，请联系管理员");
        } catch (ExcessiveAttemptsException eae ) { 
        	return R.error("尝试登录次数超限，请稍后尝试");
        }
        return R.ok("登录成功");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody R Register(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("phone") String phone,@RequestParam("email") String email) {
		SysUser sysUser=new SysUser();
		sysUser.setUsername(username);
		sysUser.setPassword(password);
		sysUser.setEmail(email);
		sysUser.setMobile(phone);
		if(sysUserService.queryByName(sysUser.getUsername())!=null) {
			return R.error("用户名已被使用");
		}
		sysUser.setStatus(1);
		sysUser.setCreateTime(DateUtils.currentTime());
		sysUser.setPassword(SHA256Util.getSHA256Str(sysUser.getPassword()));
		int result=sysUserService.save(sysUser);
		if(result!=1)
			return R.error("注册失败");
		return R.ok("注册成功");
	}
}
