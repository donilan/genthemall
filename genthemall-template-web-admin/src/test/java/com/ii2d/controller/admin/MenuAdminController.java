package com.ii2d.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ii2d.model.Menu;

@Controller
@RequestMapping("/admin/menu")
public class MenuAdminController extends com.ii2d.dbase.web.controller.AbstractController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@ModelAttribute(value="menu") Menu searchObj,
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "rows", defaultValue="10") int rows,
			ModelMap model) {
		List<Menu> list = commonService.queryForList(searchObj, page, rows);
		model.addAttribute(list);
		return "admin/menu/list";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(@ModelAttribute(value="menu") Menu instance, ModelMap model) {
		commonService.insert(instance);
		return "success";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
	public @ResponseBody String update(@ModelAttribute(value="menu") Menu instance, BindingResult result, Model model) {
		System.out.println(instance);
		System.out.println(model);
		System.out.println(result);
		return "success";
	}
	

	@Override
	public String getControllerName() {
		return "menu";
	}

	@Override
	public Class<?> getInstanceClass() {
		return Menu.class;
	}
}
