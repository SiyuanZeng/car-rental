package carrental.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import carrental.model.Vehicle;
import carrental.model.VehicleRental;

public class VehicleRentalValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return VehicleRental.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName",
				"vehicleRental.required.customerName", "Customer Name is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category",
				"vehicleRental.required.category", "Category is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationNumber",
				"vehicleRental.required.registrationNumber", "Registration Number is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookedFrom",
				"vehicleRental.required.bookedFrom", "Booked From is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookedTo",
				"vehicleRental.required.bookedTo", "Booked To is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalRent",
				"vehicleRental.required.totalRent", "Total Rent is required.");

		VehicleRental vehicleRental = (VehicleRental) target;

		if ("NONE".equals(vehicleRental.getCategory())) {
			errors.rejectValue("category", "vehicleRental.required.category");
		}

		if ("NONE".equals(vehicleRental.getRegistrationNumber())) {
			errors.rejectValue("category", "vehicleRental.required.registrationNumber");
		}


	}

}