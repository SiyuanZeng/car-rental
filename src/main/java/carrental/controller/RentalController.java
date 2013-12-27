package carrental.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;

import carrental.dao.GetCategoryDao;
import carrental.dao.GetFuelTypeDao;
import carrental.dao.jdbc.impl.GetCategoryDaoJdbcImpl;
import carrental.dao.jdbc.impl.GetFuelTypeDaoJdbcImpl;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;

public class RentalController {
	public RentalController() {
		super();
	}

	@ModelAttribute("fuelTypeList")
	public List<Vehicle> populateFuelTypeList() {
		GetFuelTypeDao dao = new GetFuelTypeDaoJdbcImpl();
		List<Vehicle> fuelTypeList = null;
		try {
			fuelTypeList = dao.getFuelType();
			System.out.println(fuelTypeList);
			Map<String, Vehicle> fuelType = new HashMap<String, Vehicle>();
			for (Vehicle vehicle : fuelTypeList) {
				if (!(fuelType.containsKey(vehicle.getFuelType()))) {
					fuelType.put(vehicle.getFuelType(), vehicle);
				}
			}
			fuelTypeList = new ArrayList<Vehicle>();
			for (Vehicle vehicle : fuelType.values()) {
				fuelTypeList.add(vehicle);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return fuelTypeList;
	}

	@ModelAttribute("categoryList")
	public List<Vehicle> populateCategoryList() {
		GetCategoryDao dao = new GetCategoryDaoJdbcImpl();
		List<Vehicle> categoryList = null;
		try {
			categoryList = dao.getAllCategory();
			Map<String, Vehicle> categoryType = new HashMap<String, Vehicle>();
			for (Vehicle vehicle : categoryList) {
				if (!(categoryType.containsKey(vehicle.getCategory()))) {
					categoryType.put(vehicle.getCategory(), vehicle);
				}
			}
			categoryList = new ArrayList<Vehicle>();
			for (Vehicle vehicle : categoryType.values()) {
				categoryList.add(vehicle);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

}