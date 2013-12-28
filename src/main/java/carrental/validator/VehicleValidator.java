package carrental.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import carrental.model.Customer;
import carrental.model.Vehicle;

public class VehicleValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return Vehicle.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationNumber",
				"vehicle.required.registrationNumber",
				"Registration Number is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category",
				"vehicle.required.category", "Category is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fuelType",
				"vehicle.required.fuelType", "Fuel Type is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer",
				"vehicle.required.manufacturer", "Manufacturer is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dailyRent",
				"vehicle.required.dailyRent", "Daily Rent is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mileage",
				"vehicle.required.mileage", "Mileage is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"vehicle.required.description", "Description is required!");

		Vehicle vehi = (Vehicle) target;

		// how to validate numbers?
		if ("NONE".equals(vehi.getFuelType())) {
			errors.rejectValue("fuelType", "vehicle.required.fuelType");
		}

		if ("NONE".equals(vehi.getCategory())) {
			errors.rejectValue("category", "vehicle.required.category");
		}

	}

}