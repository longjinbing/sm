package com.ljb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ljb.service.CmsArticleService;
import com.ljb.utils.R;

@Controller
@RequestMapping("api/article")
public class ApiArticleController extends AbstractController {
	
	@Autowired
	private CmsArticleService cmsArticleService;
	
	@RequestMapping("list")
	public @ResponseBody R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("page", cmsArticleService.apiList(params));
    }
	
	@RequestMapping("list/{id}")
	public @ResponseBody R listByCategory(@PathVariable("id") Integer id) {
        //查询列表数据
        return R.ok().put("page", cmsArticleService.apiListByCategory(id));
    }
	
	@RequestMapping("listbyids")
	public @ResponseBody R listByCategory(@RequestParam("ids") Integer[] ids) {
        //查询列表数据
        return R.ok().put("page", cmsArticleService.apiListByCategoryIds(ids));
    }
	
	@RequestMapping("article/{id}")
	public String articleDeatils(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("id", id);
        return "android/articledetails.html";
    }
	
	@RequestMapping("articledetails/{id}")
	public @ResponseBody R articleDeatils(@PathVariable("id") Integer id) {
        //查询列表数据
        return R.ok().put("data", cmsArticleService.queryObject(id));
    }
}
