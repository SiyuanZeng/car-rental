package carrental.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import carrental.model.TaskReviewStatus;
import carrental.util.DateAndTimeConversionUtil;
import carrental.validator.TaskValidator;

@Controller
public class TaskController extends SeedController {
	private static final String UPDATE_TASK = "updateTask=true";
	private static final String COPY_TASK = "copyTask";
	private static final String DELETE_TASK = "deleteTask=true";
	private static final String ADD_TASK = "/task.htm";
	private static final String REVIEW_TASK = "/reviewTask.htm";;

	TaskValidator taskValidator;

	@Autowired
	public TaskController(TaskValidator taskValidator) {
		this.taskValidator = taskValidator;
	}

	@RequestMapping(value = ADD_TASK, method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("task") Task task,
			BindingResult bindingResult, SessionStatus status, ModelMap model) {
		System.out.println("test time" + task.getTime());

		taskValidator.validate(task, bindingResult);

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

	@RequestMapping(value = ADD_TASK, method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		initAddTaskForm(model);
		return "Responsive/Responsive-AddTasks";
	}

	@RequestMapping(value = REVIEW_TASK, method = RequestMethod.GET)
	public String initReviewTask(ModelMap model) {
		initReviewTaskForm(model);

		return "Responsive/Responsive-ReviewTasks";
	}

	@RequestMapping(value = ADD_TASK, params = UPDATE_TASK, method = RequestMethod.POST)
	@ResponseBody
	public String updateTask(@RequestParam("id") String id,
			@RequestParam("newvalue") String newvalue,
			@RequestParam("colname") String colname,
			@RequestParam("coltype") String coltype) throws ServletException,
			IOException {

		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);

			// set the updated variable
			if ("Name".equals(colname)) {
				task.setName(colname);
			} else if ("Deadline".equals(colname)) {
				Date date = DateAndTimeConversionUtil.getInstance()
						.editableGridStringToDate(newvalue);
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

			taskDao.updateTask(task);
			String json = "{\"employees\": [{ \"firstName\":\"Peter\" }]}";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = ADD_TASK, params = DELETE_TASK, method = RequestMethod.POST)
	@ResponseBody
	public String deleteTask(@RequestParam("deleteRow") String deleteRow)
			throws ServletException, IOException {

		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(deleteRow));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);

			taskDao.deleteTaskById(task);
			String json = "{\"employees\": [{ \"firstName\":\"Peter\" }]}";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = ADD_TASK, params = COPY_TASK, method = RequestMethod.POST)
	@ResponseBody
	public String copyTask(@RequestParam("id") String id)
			throws ServletException, IOException {

		try {
			// get the task from db by id.
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			TaskDao taskDao = new TaskDaoImpl();
			task = taskDao.getTaskById(task);
			int Task_Id = taskDao.addTask(task);

			String json = " [{ \"Task_Id\":\"" + Task_Id + "\"}]";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = REVIEW_TASK, params = UPDATE_TASK, method = RequestMethod.POST)
	@ResponseBody
	public String updateTaskReviewStatus(@RequestParam("id") String id,
			@RequestParam("newvalue") String newvalue,
			@RequestParam("colname") String colname,
			@RequestParam("coltype") String coltype) throws ServletException,
			IOException {
		System.out.println(newvalue);
		System.out.println(id);
		System.out.println(colname);
		System.out.println(coltype);

		try {
			Task task = new Task();
			task.setId(Integer.parseInt(id));
			TaskDao taskDao = new TaskDaoImpl();
			TaskReviewStatus trs = taskDao.getTaskReviewStatus(task);
			int updatedValue = Integer.parseInt(newvalue)==0?1:2;
			System.out.println("updatedValue:   "+updatedValue);

			// set the updated variable
			if ("boolean".equals(coltype)) {
				if ("S1".equals(colname)) {
					trs.setTenMinutes(updatedValue);
					System.out.println("updated value is in 10 minutes");
				} else if ("S2".equals(colname)) {
					trs.setTwenntyFourHours(updatedValue);
				} else if ("S3".equals(colname)) {
					trs.setOneWeek(updatedValue);
				} else if ("S4".equals(colname)) {
					trs.setOneMonth(updatedValue);
				} else if ("S5".equals(colname)) {
					trs.setTwoMonth(updatedValue);
				}
			}

			taskDao.updateTaskReviewStatus(trs);
			String json = "{\"employees\": [{ \"firstName\":\"Peter\" }]}";
			return json;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

}