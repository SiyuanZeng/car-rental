package carrental.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import carrental.dao.AddVehicleRentalDao;
import carrental.dao.GetRegNoDao;
import carrental.dao.GetRentDao;
import carrental.dao.jdbc.impl.AddVehicleRentalDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetRegNoDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetRentaoJdbcImpl;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;
import carrental.model.VehicleRental;
import carrental.validator.VehicleRentalValidator;

@Controller
@RequestMapping("/vehicleRental.htm")
public class VehicleRentalController extends RentalController {
	VehicleRentalValidator vehicleRentalValidator;

	@Autowired
	public VehicleRentalController(VehicleRentalValidator vehicleRentalValidator) {
		this.vehicleRentalValidator = vehicleRentalValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("vehicleRental") VehicleRental vehicleRental,
			BindingResult bindingResult, SessionStatus status) {
		System.out.println("payment_status"+vehicleRental.getPaymentStatus());
		vehicleRentalValidator.validate(vehicleRental, bindingResult);

		if (bindingResult.hasErrors()) {
			// if validator failed
			return "VehicleRentalForm";
		} else {
			AddVehicleRentalDao dao = new AddVehicleRentalDaoJdbcImpl();
			try {
				dao.addVehicleRental(vehicleRental);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status.setComplete();
			// form success
			return "VehicleRentalSuccess";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {

		VehicleRental vehicleRental = new VehicleRental();
		// Make "Spring MVC" as default checked value
		/*
		 * vehicleRental.setFavFramework(new String[] { "Spring MVC" });
		 *
		 * // Make "Make" as default radio button selected value
		 * vehicleRental.setSex("M");
		 *
		 * // make "Hibernate" as the default java skills selection
		 * vehicleRental.setJavaSkills("Hibernate");
		 *
		 * // initilize a hidden value
		 * vehicleRental.setSecretValue("I'm hidden value");
		 */

		// command object
		model.addAttribute("vehicleRental", vehicleRental);

		// return form view
		return "VehicleRentalForm";
	}

	@RequestMapping(params = "registrationNumber=true", method = RequestMethod.POST)
	public @ResponseBody
	String onSelectChange(@RequestParam("category") String category) {
		List<Vehicle> v = null;
		try {
			GetRegNoDao dao = new GetRegNoDaoJdbcImpl();
			v = dao.getRegNo(category);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		String registrationNumberList = "[";
		ListIterator<Vehicle> iterator = v.listIterator();
		while (iterator.hasNext()) {
			registrationNumberList += "{\"registrationNumber\": \""
					+ iterator.next().getRegistrationNumber() + "\"}";
			if (iterator.hasNext()) {
				registrationNumberList += ",";
			} else {
				registrationNumberList += "]";
			}
		}
		return registrationNumberList;
	}

	@RequestMapping(params = "rent=true", method = RequestMethod.GET)
	@ResponseBody
	public String getRentAction(
			@RequestParam("registrationNumber") String registrationNumber,
			@RequestParam("days") String days) throws ServletException,
			IOException {
		try {
			System.out.println(days);
			GetRentDao dao = new GetRentaoJdbcImpl();
			Integer rent = dao.getRent(registrationNumber);
			System.out.println(rent);
			Integer totalRent = rent * Integer.parseInt(days);
			System.out.println(totalRent);
			System.out.println(totalRent);
			return totalRent.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}