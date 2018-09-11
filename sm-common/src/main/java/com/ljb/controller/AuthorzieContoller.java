package com.ljb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljb.service.SysMenuService;
import com.ljb.service.SysRoleService;
import com.ljb.utils.R;

@Controller
@RequestMapping("authorzie")
public class AuthorzieContoller extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("/set/{role_id}")
	public String authorize(@PathVariable Integer role_id,Model model) {
		model.addAttribute("role_id", role_id);
		return "admin/set";
	}
	
	/*@RequestMapping("/list/{role_id}")
	@ResponseBody
	public R list(@PathVariable Integer role_id) {
		
		return R.ok().put("menulist", sysMenuService.authorizeList(role_id,getSysUserId()));
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public R list(@RequestParam("role_id") Integer role_id,@RequestParam("menu_ids") Integer menu_ids[]) {
		
		  
		
		return R.ok().put("menulist", sysMenuService.authorizeList(role_id,getSysUserId()));
	}*/
	
}
