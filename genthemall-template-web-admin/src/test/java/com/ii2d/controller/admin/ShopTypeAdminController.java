package com.ii2d.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ii2d.model.ShopType;

@Controller
@RequestMapping("/admin/shopType")
public class ShopTypeAdminController extends com.ii2d.dbase.web.controller.AbstractController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@ModelAttribute(value="shopType") ShopType searchObj,
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "rows", defaultValue="10") int rows,
			ModelMap model) {
		List<ShopType> list = commonService.queryForList(searchObj, page, rows);
		model.addAttribute(list);
		return "admin/shopType/list";
	}

	@Override
	public String getControllerName() {
		return "shopType";
	}

	@Override
	public Class<?> getInstanceClass() {
		return ShopType.class;
	}
}
