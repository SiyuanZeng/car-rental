package carrental.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.support.SessionStatus;

import carrental.dao.CategoryDao;
import carrental.dao.TaskDao;
import carrental.dao.jdbc.impl.CategoryDaoImpl;
import carrental.dao.jdbc.impl.TaskDaoImpl;
import carrental.exceptions.DaoException;
import carrental.model.Category;
import carrental.model.Task;
import carrental.util.WriteXMLFile;
import carrental.validator.TaskValidator;

@Controller
@RequestMapping("/task.htm")
public class TaskController {
	TaskValidator taskValidator;

	@Autowired
	public TaskController(TaskValidator taskValidator) {
		this.taskValidator = taskValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("task") Task task,
			BindingResult bindingResult, SessionStatus status) {

		taskValidator.validate(task, bindingResult);

		System.out.println(task.getCategory().getName());
		System.out.println(task.getName());

		if (bindingResult.hasErrors()) {
			// if validator failed
			return "Seed-TaskForm";
		} else {
			TaskDao taskDao = new TaskDaoImpl();
			try {
				taskDao.addTask(task);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			status.setComplete();
			// form success
			return "Seed-TaskSuccess";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Task task = new Task();
		task.setCategory(new Category());//nested object.
		model.addAttribute("task", task);
		List<Task> tasklist =null;
        try {
        	TaskDao dao = new TaskDaoImpl();
        	tasklist = dao.getAllTasks();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WriteXMLFile xml = new WriteXMLFile();
		xml.createXml(tasklist);


		return "Seed-TaskForm";
	}

/*	@ModelAttribute("categoryList")
	public List<String> populateCategoryList() {
		CategoryDao dao = new CategoryDaoImpl();
		List<Category> categoryList = null;
		List<String> categoryStringList = null;
		try {
			categoryList = dao.getAllCategory();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Category category : categoryList) {
			categoryStringList.add(category.getName());
		}

		return categoryStringList;
	}*/

}