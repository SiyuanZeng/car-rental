package carrental.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import carrental.model.Specimen;
import carrental.service.DummyDB;

@Controller
public class HomeController {

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String getForm(ModelMap model) {
		model.addAttribute("specimen", new Specimen());
		model.addAttribute("specimenTypeList", DummyDB.getSpecimenTypeList());
		return "home";
	}

	@RequestMapping(value = "/exchangejson", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<String>> onSelectChange(@RequestBody String newInput) {
		System.out.println(newInput);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> specimenNameList = DummyDB.getSpecimenNameList(newInput);
		map.put("specimenNameList", specimenNameList);
		System.out.println("here it is.");
		return map;
	}
}
