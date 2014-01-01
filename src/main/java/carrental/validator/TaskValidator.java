package carrental.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import carrental.model.Task;

public class TaskValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return Task.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"task.required.name", "Task Name is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "time",
				"task.required.time", "Time is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deadline",
				"task.required.deadline", "Deadline To is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"task.required.description", "Description is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category",
				"task.required.category", "Category is required.");

	}

}