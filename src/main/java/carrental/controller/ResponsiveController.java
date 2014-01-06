package carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcomeResponsive.htm")
public class ResponsiveController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		System.out.println("responsive");

		return "redirect:/static/WelcomeResponsive.html";
	}


}