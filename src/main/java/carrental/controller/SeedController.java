package carrental.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import carrental.dao.TaskDao;
import carrental.dao.jdbc.impl.TaskDaoImpl;
import carrental.exceptions.DaoException;
import carrental.model.Category;
import carrental.model.Task;
import carrental.util.WriteXMLFile;

@Controller
public class SeedController {


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


	public void initAddTaskForm(ModelMap model){
		Task task = new Task();
		task.setCategory(new Category());// nested object.
		model.addAttribute("task", task);
		List<Task> tasklist = null;
		try {
			TaskDao dao = new TaskDaoImpl();
			tasklist = dao.getAllTasks();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WriteXMLFile xml = new WriteXMLFile();
		xml.createAddTaskXml(tasklist);
	}

	public void initReviewTaskForm(ModelMap model){
		Task task = new Task();
		task.setCategory(new Category());
		model.addAttribute("task", task);
		List<Task> tasklist = null;

		try {
			TaskDao dao = new TaskDaoImpl();
			tasklist = dao.getAllTasks();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		WriteXMLFile xml = new WriteXMLFile();
		xml.createReviewTaskXml(tasklist);
	}

}