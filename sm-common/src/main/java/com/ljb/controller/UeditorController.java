package com.ljb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.baidu.ueditor.ActionEnter;
import com.ljb.utils.JsonFilterUtils;

@Controller
@RequestMapping("ueditor")
public class UeditorController {

	@RequestMapping("/controller")
	public void RoutedRequest(HttpServletRequest request,HttpServletResponse response) {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		ActionEnter actionEnter=new ActionEnter(request, rootPath);
		String result=actionEnter.exec();
		JSONObject r=JSONObject.parseObject(result);
		String suffix=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 
		r=JsonFilterUtils.changeObjectUrlMsg(suffix, r);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(r.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
