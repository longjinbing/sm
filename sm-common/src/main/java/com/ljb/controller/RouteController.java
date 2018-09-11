package com.ljb.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ljb.shiro.ShiroUtils;


@Controller
public class RouteController {
	
	@RequestMapping(value="/{module}/{page}.html",method=RequestMethod.GET)
	public String Route(@PathVariable("module") String module,@PathVariable("page") String page,@RequestParam Map<String, Object> params,Model model) {
		return module+"/"+page;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "admin/index";
	}
}
