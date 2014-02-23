package carrental.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import carrental.model.Customer;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;
import carrental.model.VocabularyCategory;
import carrental.model.VocabularyForm;

public class VocabularyValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return VocabularyForm.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pronouciation",
				"required.pronouciation", "Pronouciation is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "etymology",
				"required.etymology", "Etymology is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vocabularyCategory",
				"required.vocabularyCategory", "VocabularyCategory is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "variedFormSubject",
				"required.variedFormSubject", "VariedFormSubject is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "variedFormAdverb",
				"required.variedFormAdverb", "VariedFormAdverb is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "variedFormVerb",
				"required.variedFormVerb", "VariedFormVerb is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "variedFormAdjective",
				"required.variedFormAdjective", "VariedFormAdjective is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "variedFormNoun",
				"required.variedFormNoun", "VariedFormNoun is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "synonym",
				"required.synonym", "Synonym is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "antonym",
				"required.antonym", "Antonym is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "synonym",
				"required.synonym", "Synonym is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "note",
				"required.note", "Note is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "example",
				"required.example", "Example is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "synonym",
				"required.synonym", "Synonym is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalExperience",
				"required.personalExperience", "PersonalExperience is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writing",
				"required.writing", "Writing is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memoryTag",
				"required.memoryTag", "MemoryTag is required.");
	}

}
