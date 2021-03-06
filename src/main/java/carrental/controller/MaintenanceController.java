package carrental.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MaintenanceController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("MaintenanceController handleRequestInternal");
		ModelAndView model = new ModelAndView("MaintenancePage");
		model.addObject("classname", "MaintenanceController");

		return model;
	}

}