package carrental.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class NormalHourController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("NormalHourController handleRequestInternal");

		ModelAndView model = new ModelAndView("WelcomePage");
		model.addObject("classname", "NormalHourController");

		return model;
	}

}