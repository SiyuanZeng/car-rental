package carrental.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import carrental.dao.TaskDao;
import carrental.dao.VocabularyDao;
import carrental.dao.jdbc.impl.TaskDaoImpl;
import carrental.dao.jdbc.impl.VocabularyDaoImpl;
import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.VocabularyForm;
import carrental.validator.VocabularyValidator;

@Controller
public class VocabularyController extends SeedController {
	private static final String FANCY_BOX = "/fancyBox.htm";
	private static final String JQUERY_FORM_FOR_ONE = "/jqf1.htm";
	private static final String VOCABULARY_FORM = "jqf1/jqf1";
	private static final String ADD_VOCABULARY = "/addVocabulary.htm";

	VocabularyValidator vocabularyValidator;

	@Autowired
	public VocabularyController(VocabularyValidator vocabularyValidator) {
		this.vocabularyValidator = vocabularyValidator;
	}

	@RequestMapping(value = FANCY_BOX, method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("task") Task task,
			BindingResult bindingResult, SessionStatus status, ModelMap model) {
		System.out.println("test time" + task.getTime());

		vocabularyValidator.validate(task, bindingResult);

		if (bindingResult.hasErrors()) {
			return "Responsive/Responsive-AddTasks";
		} else {
			TaskDao taskDao = new TaskDaoImpl();
			try {
				taskDao.addTask(task);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			status.setComplete();
			initForm(model);
			return "Responsive/Responsive-AddTasks";
		}
	}

	@RequestMapping(value = JQUERY_FORM_FOR_ONE, method = RequestMethod.POST)
	public ModelAndView addVocabulary(
			@ModelAttribute("vocabularyForm") VocabularyForm vocabularyForm,
			BindingResult bindingResult, SessionStatus status,
			ModelAndView model) {

		vocabularyValidator.validate(vocabularyForm, bindingResult);

		System.out.println(vocabularyForm.getVocabularyCategory().getCategoriesList());


		VocabularyDao dao = new VocabularyDaoImpl();
		try {
			dao.addVocabulary(vocabularyForm);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		model.setViewName(JQUERY_FORM_FOR_ONE);
		model.addObject("vocabularyForm", vocabularyForm);

		if (bindingResult.hasErrors()) {
			return model;
		} else {
			// add new vocabulary.
			status.setComplete();
			return model;
		}
	}

	@RequestMapping(value = FANCY_BOX, method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		return "redirect:/static/fancyBox.html";
	}

	@RequestMapping(value = JQUERY_FORM_FOR_ONE, method = RequestMethod.GET)
	public ModelAndView initjQueryForm(ModelAndView model) {

		List<String> categories = new ArrayList<String>();
		categories.add("Verb");
		categories.add("Adverb");
		categories.add("Adjective");
		categories.add("Noun");
		categories.add("Preposition");
		categories.add("Pronoun");
		categories.add("Interjection");
		categories.add("Conjunction");
		categories.add("Prefix");
		categories.add("Suffix");
		categories.add("Uncategorized");

/*
 		private boolean verb;
		private boolean adverb;
		private boolean adjective;
		private boolean noun;
		private boolean preposition;
		private boolean pronoun;
		private boolean interjection;
		private boolean conjunction;
		private boolean prefix;
		private boolean suffix;
		private boolean uncategorized;
*/

		model.addObject("categoriesList", categories);
		model.addObject("vocabularyForm", new VocabularyForm());
		model.setViewName(VOCABULARY_FORM);
        System.out.print("Category List");

		return model;

		/*
		 * model = new ModelAndView("jqf1/jqf1");
		 * model.addObject("vocabularyForm", new VocabularyForm()); return
		 * model;
		 */
	}

}
