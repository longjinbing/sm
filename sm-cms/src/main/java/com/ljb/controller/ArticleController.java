package com.ljb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/article")
public class ArticleController extends AbstractController {

	
	@RequestMapping("/add")
	public String update(Model model) {
		model.addAttribute("id", "");
		return "cms/editarticle.html";
	}
	
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("id", id);
		return "cms/editarticle.html";
	}
	
}
