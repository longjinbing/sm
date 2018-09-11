package com.ljb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ljb.entity.SysUser;
import com.ljb.service.SysUserService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;
import com.ljb.utils.SHA256Util;
import com.ljb.viewmodel.LoginModel;


@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String Login() {
		return "login";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String Register() {
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody R Login(@RequestBody LoginModel model) {
		Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(model.getUsername(), SHA256Util.getSHA256Str(model.getPassword()));
        token.setRememberMe(model.getRemember());
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
	public @ResponseBody R Register(@RequestBody SysUser sysUser) {
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
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout() {   
        Subject currentUser = SecurityUtils.getSubject();       
        currentUser.logout();    
        return "redirect:/login";
    }
	
	
	@RequestMapping(value="/isexist",method=RequestMethod.GET)
	@ResponseBody
    public R isExist(@RequestParam("username") String username) {   
        if(sysUserService.queryByName(username)==null) {
        	return R.ok("√");
        }else{
        	return R.error(1, "用户名已存在");
        }
    }
	
	
	
}
