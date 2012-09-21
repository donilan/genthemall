package ${packageName}.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${packageName}.model.${pascalName};

@Controller
@RequestMapping("/admin/${camelName}")
public class ${pascalName}AdminController extends com.ii2d.dbase.web.controller.AbstractController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@ModelAttribute(value="${camelName}") ${pascalName} searchObj,
			@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "rows", defaultValue="10") int rows,
			ModelMap model) {
		List<${pascalName}> list = commonService.queryForList(searchObj, page, rows);
		model.addAttribute(list);
		return "admin/${camelName}/list";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(
			@ModelAttribute(value="${camelName}") ${pascalName} instance) {
		commonService.insert(instance);
		return "success";
	}
	<%if(idColumn) {%>
	@RequestMapping(method = RequestMethod.POST, value="{id}")
	public @ResponseBody String update(
			@ModelAttribute(value="${camelName}") ${pascalName} instance,
			@PathVariable(value = "id") ${idColumn.classType} ${idColumn.camelName}) {
		instance.${idColumn.setter}(${idColumn.camelName});
		commonService.update(instance);
		return "success";
	}
	<%}%>

	@Override
	public String getControllerName() {
		return "${camelName}";
	}

	@Override
	public Class<?> getInstanceClass() {
		return ${pascalName}.class;
	}
}
