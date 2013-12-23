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
				"required.registrationNumber",
				"Registration Number is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category",
				"required.category", "Category is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fuelType",
				"required.fuelType", "Fuel Type is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer",
				"required.manufacturer", "Manufacturer is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dailyRent",
				"required.dailyRent", "Daily Rent is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mileage",
				"required.mileage", "Mileage is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"required.description", "Description is required!");

		Vehicle vehi = (Vehicle) target;

		// how to validate numbers?
		if ("NONE".equals(vehi.getFuelType())) {
			errors.rejectValue("fuelType", "required.fuelType");
		}

		if ("NONE".equals(vehi.getCategory())) {
			errors.rejectValue("category", "required.category");
		}

	}

}