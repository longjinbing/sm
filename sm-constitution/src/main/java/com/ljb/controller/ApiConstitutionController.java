package com.ljb.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.validator.Var;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.android.Android10Instantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ljb.annotation.Desc;
import com.ljb.entity.Constitution;
import com.ljb.entity.ConstitutionResult;
import com.ljb.entity.ResultDetails;
import com.ljb.query.ConstitutionQuery;
import com.ljb.service.ConstitutionDetailsService;
import com.ljb.service.ConstitutionResultService;
import com.ljb.service.ConstitutionService;
import com.ljb.service.ConstiutionQuestionService;
import com.ljb.service.ResultDetailsService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;

@Controller
@RequestMapping("api/constitution")
public class ApiConstitutionController extends AbstractController {
	
	 @Autowired
	private ConstiutionQuestionService constiutionQuestionService;
	 
	 @Autowired
		private ConstitutionService constiutionService;
	 
	 @Autowired
	    private ConstitutionResultService constitutionResultService;
	 
	 @Autowired
	    private ResultDetailsService resultDetailsService;
	 
	 @Autowired
	    private ConstitutionDetailsService constitutionDetailsService;

	@RequestMapping("/saveresult")
	public @ResponseBody R saveResult(@RequestParam Map<String,Object> map) {
		boolean result=constitutionResultService.saveResult(map);
		if(!result)
			return R.error(-1, "测试失败");
		return R.ok("成功").put("url", "/api/constitution/success");
	}
	
	@RequestMapping("/success")
	public @ResponseBody R result(Model model) {
		ConstitutionResult constitutionResult=constitutionResultService.queryObjectByUserId(getSysUserId());
		return R.ok().put("data",constitutionResult.getId());
	}
	
	@RequestMapping("/resultlist")
    public @ResponseBody R list() {
        //查询列表数据
        return R.ok().put("page", constitutionResultService.queryList(getSysUserId()));
    }
	
}
