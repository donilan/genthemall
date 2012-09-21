package com.ii2d.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ii2d.model.User;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController extends com.ii2d.dbase.web.controller.AbstractController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@ModelAttribute(value="user") User searchObj,
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "rows", defaultValue="10") int rows,
			ModelMap model) {
		List<User> list = commonService.queryForList(searchObj, page, rows);
		model.addAttribute(list);
		return "admin/user/list";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(@ModelAttribute(value="user") User instance) {
		commonService.insert(instance);
		return "success";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
	public @ResponseBody String update(@ModelAttribute(value="user") User instance) {
		commonService.update(instance);
		return "success";
	}
	

	@Override
	public String getControllerName() {
		return "user";
	}

	@Override
	public Class<?> getInstanceClass() {
		return User.class;
	}
}
