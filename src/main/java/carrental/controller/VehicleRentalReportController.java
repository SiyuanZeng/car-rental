package carrental.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carrental.dao.GetReportDao;
import carrental.dao.jdbc.impl.GetReportDaoJdbcImpl;
import carrental.exceptions.DaoException;
import carrental.model.ReportEntry;
import carrental.validator.VehicleRentalValidator;

@Controller
@RequestMapping("/vehicleRentalReport.htm")
public class VehicleRentalReportController extends RentalController {

	private static final Logger logger=Logger.getLogger(VehicleRentalReportController.class);


	VehicleRentalValidator vehicleRentalValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		System.out.println("autobuild123");
		// VehicleRental vehicleRental = new VehicleRental();
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
		// model.addAttribute("vehicleRental", vehicleRental);

		// return form view
		return "VehicleRentalReport";
	}

	@ModelAttribute("reportList")
	public List<ReportEntry> populateReportList() {
		List<ReportEntry> reportList = null;
		logger.info("reportList, starting the method");
		try {
			GetReportDao dao = new GetReportDaoJdbcImpl();
			reportList = dao.getReport();
		} catch (DaoException e) {
			logger.debug("populate report list, dao exception");
			e.printStackTrace();
		}
		return reportList;
	}

}