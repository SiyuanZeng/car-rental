package carrental.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import carrental.dao.TaskDao;
import carrental.dao.jdbc.impl.TaskDaoImpl;
import carrental.exceptions.DaoException;
import carrental.model.Category;
import carrental.model.Task;
import carrental.util.DateAndTimeConversionUtil;
import carrental.util.WriteXMLFile;
import carrental.validator.TaskValidator;

@Controller
@RequestMapping("/task.htm")
public class TaskController {
	TaskValidator taskValidator;
	private boolean resulttrue;

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
			BindingResult bindingResult, SessionStatus status, ModelMap model) {

		taskValidator.validate(task, bindingResult);

		System.out.println(task.getStartTime());
		System.out.println(task.getEndTime());

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
			initForm(model);
			return "Seed-TaskForm";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
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
		xml.createXml(tasklist);

		return "Seed-TaskForm";
	}

	/*
	 * id: editableGrid.getRowId(rowIndex), column: columnIndex, tablename : *
	 * editableGrid.name, newvalue: editableGrid.getColumnType(columnIndex) == *
	 * "boolean" ? (newValue ? 1 : 0) : newValue, colname: *
	 * editableGrid.getColumnName(columnIndex), coltype: *
	 * editableGrid.getColumnType(columnIndex)
	 */

	@RequestMapping(params ="updateTask=true", method = RequestMethod.POST)
	@ResponseBody
	public String updateTask(@RequestParam("id") String id,
			@RequestParam("newvalue") String newvalue,
			@RequestParam("colname") String colname,
			@RequestParam("coltype") String coltype) throws ServletException,
			IOException {

		System.out.println("update task");
		System.out.println(id);
		System.out.println(newvalue);
		System.out.println(colname);
		System.out.println(coltype);


		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);
			System.out.println(task);

		// set the updated variable
			if ("Name".equals(colname)) {
				task.setName(colname);
			} else if ("Deadline".equals(colname)) {
				Date date = new DateAndTimeConversionUtil().editableGridStringToDate(newvalue);
				task.setDeadline(date);
			} else if ("Time".equals(colname)) {
				int value = Integer.parseInt(newvalue);
				task.setTime(value);
			} else if ("Description".equals(colname)) {
				task.setDescription(newvalue);
			} else if ("Category".equals(colname)) {
				Category category = new Category(newvalue);
				task.setCategory(category);
			}

		/*
		 * case "boolean": if (newvalue.equals("1")) { boolean resulttrue =
		 * true; } if (newvalue.equals("1")) { boolean resultfalse = false; }
		 * break;
		 */

				taskDao.updateTask(task);
				System.out.println("update complete");
				String json = "{\"employees\": [{ \"firstName\":\"Peter\" }]}";
				return json;
			} catch (DaoException e) {
				e.printStackTrace();
			}

			return null;
	}

	@RequestMapping(params = "deleteTask=true", method = RequestMethod.POST)
	@ResponseBody
	public String deleteTask(@RequestParam("deleteRow") String deleteRow) throws ServletException,
			IOException {

		System.out.println("delete task");
		System.out.println(deleteRow);

		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(deleteRow));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);
			System.out.println(task);

			taskDao.deleteTaskById(task);
			System.out.println("Delete complete");
			String json = "{\"employees\": [{ \"firstName\":\"Peter\" }]}";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(params = "copyTask", method = RequestMethod.POST)
	@ResponseBody
	public String copyTask(@RequestParam("id") String id) throws ServletException,
	IOException {

		System.out.println("copy task");
		System.out.println(id);

		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);
			System.out.println(task);
			int Task_Id = taskDao.addTask(task);

			System.out.println("copy complete"+Task_Id);
			String json = " [{ \"Task_Id\":\""+Task_Id+"\"}]";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return null;
	}


}