package carrental.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carrental.dao.AddBookingRentalVehicleDao;
import carrental.dao.AddNewVehicleDao;
import carrental.dao.GetCategoryDao;
import carrental.dao.GetFuelTypeDao;
import carrental.dao.GetRegNoDao;
import carrental.dao.GetRentDao;
import carrental.dao.GetReportDao;
import carrental.dao.jdbc.impl.AddBookingRentalVehicleDaoJdbcImpl;
import carrental.dao.jdbc.impl.AddNewVehicleDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetCategoryDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetFuelTypeDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetRegNoDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetRentaoJdbcImpl;
import carrental.dao.jdbc.impl.GetReportDaoJdbcImpl;
import carrental.entity.RentalVehicle;
import carrental.entity.ReportEntry;
import carrental.entity.Vehicle;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;



/**
 * @author M1017325
 *
 */

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String BOOK_VEHICLE = "booking.action";
	private static final String BOOK_VEHICLE_FORM = "bookVehicleForm.action";
	private static final String ADD_VEHICLE_FORM = "addVehicleForm.action";
	private static final String GET_REG_NO = "getRegNo.action";
	private static final String GET_RENT = "getRent.action";
	private static final String ADD_VEHICLE = "addVehicle.action";
	private static final String REPORT = "reporting.action";

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String URI = request.getRequestURI();
		if (URI.endsWith(BOOK_VEHICLE)) {
			getAllCatgoryAction(request, response);
		} else if (URI.endsWith(ADD_VEHICLE)) {
			getFuelType(request, response);
		} else if (URI.endsWith(GET_REG_NO)) {
			getRegNOAction(request, response);
		} else if (URI.endsWith(GET_RENT)) {
			getRentAction(request, response);
		} else if (URI.endsWith(BOOK_VEHICLE_FORM)) {
			addBookingVehicleAction(request, response);
		} else if (URI.endsWith(ADD_VEHICLE_FORM)) {
			addNewVehicleAction(request, response);
		} else if (URI.endsWith(REPORT)) {
			getReport(request, response);
		} else {
			response.sendError(404, "Requested URL not found");
		}
	}

	private void getFuelType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			GetFuelTypeDao dao = new GetFuelTypeDaoJdbcImpl();
			List<Vehicle> v = dao.getFuelType();

			Map<String, Vehicle> fuelType = new HashMap<String, Vehicle>();
			for (Vehicle vehicle : v) {
				if (!(fuelType.containsKey(vehicle.getFuelType()))) {
					fuelType.put(vehicle.getFuelType(), vehicle);
				}
			}
			v = new ArrayList<Vehicle>();
			for (Vehicle vehicle : fuelType.values()) {
				v.add(vehicle);
			}

			request.setAttribute("v", v);

			GetCategoryDao categoryDao = new GetCategoryDaoJdbcImpl();
			List<Vehicle> c = categoryDao.getAllCategory();
			Map<String, Vehicle> categoryType = new HashMap<String, Vehicle>();
			for (Vehicle vehicle : c) {
				if (!(categoryType.containsKey(vehicle.getCategory()))) {
					categoryType.put(vehicle.getCategory(), vehicle);
				}
			}
			c = new ArrayList<Vehicle>();
			for (Vehicle vehicle : categoryType.values()) {
				c.add(vehicle);
			}

			request.setAttribute("c", c);

			System.out.println(c);
			request.getRequestDispatcher("WEB-INF/jsp/addVehicle.jsp").forward(
					request, response);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

	private void getRentAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String r = request.getParameter("r");
			String d = request.getParameter("days");
			Integer days = Integer.parseInt(d);
			GetRentDao dao = new GetRentaoJdbcImpl();
			Integer rent = dao.getRent(r);

			Integer totalRent = rent * days;
			;
			request.setAttribute("rent", totalRent);
			System.out.println(totalRent);
			request.getRequestDispatcher("WEB-INF/jsp/showTotalRent.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getRegNOAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String category = request.getParameter("category");
			GetRegNoDao dao = new GetRegNoDaoJdbcImpl();
			List<Vehicle> v = dao.getRegNo(category);
			request.setAttribute("vehicle", v);
			System.out.println(v);
			request.getRequestDispatcher("WEB-INF/jsp/RegNoDropdown.jsp")
					.forward(request, response);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

	private void addBookingVehicleAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forwardPath = "WEB-INF/jsp/success.jsp";
		try {
			String custName = request.getParameter("customer_name");
			String category = request.getParameter("category");
			String regNo = request.getParameter("reg_no");

			String sDate = request.getParameter("booked_from");
			String eDate = request.getParameter("booked_to");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date bookedFrom = sdf.parse(sDate);
			Date bookedTo = sdf.parse(eDate);

			String tRent = request.getParameter("total_rent");
			;
			Integer totalRent = Integer.parseInt(tRent);
			String paymentStatus = request.getParameter("payment");
			if (paymentStatus == null) {
				paymentStatus = "unpaid";

			}
			RentalVehicle r = new RentalVehicle();
			r.setCustomerName(custName);
			r.setCategory(category);
			r.setRegistrationNumber(regNo);
			r.setBookedFrom(bookedFrom);
			r.setBookedTo(bookedTo);
			r.setTotalRent(totalRent);
			r.setPaymentStatus(paymentStatus);
			AddBookingRentalVehicleDao dao = new AddBookingRentalVehicleDaoJdbcImpl();
			dao.addRentalVehicle(r);
			System.out.println("Data Added");
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "WEB-INF/jsp/failure.jsp";

		}
		request.getRequestDispatcher(forwardPath).forward(request, response);

	}

	private void addNewVehicleAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forwardPath = "WEB-INF/jsp/success.jsp";
		try {
			String registrationNumber = request
					.getParameter("registration_number");
			String category = request.getParameter("category");
			String fuelType = request.getParameter("fuel_type");

			String dailyRent = request.getParameter("daily_rent");
			String mileage = request.getParameter("mileage");
			String description = request.getParameter("description");

			Vehicle vehicle = new Vehicle();
			vehicle.setCategory(category);
			vehicle.setDailyRent(Integer.parseInt(dailyRent));
			vehicle.setFuelType(fuelType);
			vehicle.setMileage(Integer.parseInt(mileage));
			vehicle.setRegistrationNumber(registrationNumber);

			AddNewVehicleDao dao = new AddNewVehicleDaoJdbcImpl();
			dao.addNewVehicle(vehicle);
			System.out.println("Data Added");
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "WEB-INF/jsp/failure.jsp";

		}
		request.getRequestDispatcher(forwardPath).forward(request, response);

	}

	private void getAllCatgoryAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "WEB-INF/jsp/vehicleBooking.jsp";
		try {
			GetCategoryDao dao = new GetCategoryDaoJdbcImpl();
			List<Vehicle> v = dao.getAllCategory();
			request.setAttribute("v", v);
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "WEB-INF/jsp/failure.jsp";
		}
		request.getRequestDispatcher(forwardPath).forward(request, response);

	}

	private void getReport(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "WEB-INF/jsp/reportVehicleBooking.jsp";
		try {
			GetReportDao dao = new GetReportDaoJdbcImpl();
			List<ReportEntry> reportList = dao.getReport();
			request.setAttribute("reportList", reportList);
			System.out.println(reportList);
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "WEB-INF/jsp/failure.jsp";
		}
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

}
