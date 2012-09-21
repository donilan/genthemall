package com.ii2d.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ii2d.model.NewsType;

@Controller
@RequestMapping("/admin/newsType")
public class NewsTypeAdminController extends com.ii2d.dbase.web.controller.AbstractController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@ModelAttribute(value="newsType") NewsType searchObj,
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "rows", defaultValue="10") int rows,
			ModelMap model) {
		List<NewsType> list = commonService.queryForList(searchObj, page, rows);
		model.addAttribute(list);
		return "admin/newsType/list";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(
			@ModelAttribute(value="newsType") NewsType instance) {
		commonService.insert(instance);
		return "success";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="{id}")
	public @ResponseBody String update(
			@ModelAttribute(value="newsType") NewsType instance,
			@PathVariable(value = "id") java.lang.Integer id) {
		instance.setId(id);
		commonService.update(instance);
		return "success";
	}
	

	@Override
	public String getControllerName() {
		return "newsType";
	}

	@Override
	public Class<?> getInstanceClass() {
		return NewsType.class;
	}
}
