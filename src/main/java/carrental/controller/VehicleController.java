package carrental.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import carrental.dao.AddNewVehicleDao;
import carrental.dao.jdbc.impl.AddNewVehicleDaoJdbcImpl;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;
import carrental.validator.VehicleValidator;

@Controller
@RequestMapping("/vehicle.htm")
public class VehicleController extends RentalController {

	VehicleValidator vehicleValidator;

	@Autowired
	public VehicleController(VehicleValidator vehicleValidator) {
		this.vehicleValidator = vehicleValidator;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("vehicle") Vehicle vehicle,
			BindingResult result, SessionStatus status) {
		vehicleValidator.validate(vehicle, result);

		if (result.hasErrors()) {
			// if validator failed
			return "VehicleForm";
		} else {
			status.setComplete();
			// form success
			AddNewVehicleDao dao = new AddNewVehicleDaoJdbcImpl();
			try {
				dao.addNewVehicle(vehicle);
				System.out.println("Data Added");
			} catch (DaoException e) {
				e.printStackTrace();
			}
			return "VehicleSuccess";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {

		Vehicle vehicle = new Vehicle();
		// Make "Spring MVC" as default checked value
		// Make "Make" as default radio button selected value
		// make "Hibernate" as the default java skills selection
		// initilize a hidden value
		vehicle.setSecretValue("I'm hidden value");
		// command object
		model.addAttribute("vehicle", vehicle);
		// return form view
		return "VehicleForm";
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@ModelAttribute("numberList")
	public List<String> populateNumberList() {
		// Data referencing for number radiobuttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");

		return numberList;
	}

	@ModelAttribute("javaSkillsList")
	public Map<String, String> populateJavaSkillList() {

		// Data referencing for java skills list box
		Map<String, String> javaSkill = new LinkedHashMap<String, String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");

		return javaSkill;
	}

	@ModelAttribute("countryList")
	public Map<String, String> populateCountryList() {

		// Data referencing for java skills list box
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");

		return country;
	}

}