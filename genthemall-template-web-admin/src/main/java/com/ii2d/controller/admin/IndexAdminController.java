package com.ii2d.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/index")
public class IndexAdminController {

	@RequestMapping(method = RequestMethod.GET, value="page")
	public @ResponseBody String index() {
		return "Hello world";
	}
}
