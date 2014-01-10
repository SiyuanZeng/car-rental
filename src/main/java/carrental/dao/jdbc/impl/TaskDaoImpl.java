package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalTime;

import carrental.constants.DbConstants;
import carrental.dao.CategoryDao;
import carrental.dao.TaskDao;
import carrental.exceptions.DaoException;
import carrental.model.Category;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;

/**
 * @author M1017325
 *
 */

public class TaskDaoImpl extends BaseDaoJdbcImpl implements TaskDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int primaryKey = -1;

	@Override
	public int addTask(Task task) throws DaoException {

		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.INSERT_TASK,
					Statement.RETURN_GENERATED_KEYS);

			// get Category Id.
			CategoryDao categoryDao = new CategoryDaoImpl();
			Category category = categoryDao.findByName(task.getCategory());
			System.out.println("updating, category id is " + category.getId());
			// Is this correct?
			if (category.getId() == 0) {
				int key = categoryDao.addCategory(category);
				System.out.println("add category, the generated key is ...."
						+ key);
				category.setId(key);
			}
			task.setCategory(category);

			pst.setString(1, null);
			pst.setInt(2, category.getId());
			pst.setString(3, task.getName());
			pst.setDate(4, new Date(task.getDeadline().getTime()));
			pst.setTime(5, new Time(task.getStartTime().toDateTimeToday().getMillis()));
			pst.setInt(6, task.getTime());
			pst.setTime(7, new Time(task.getHappyTime().toDateTimeToday().getMillis()));
			pst.setTime(8, new Time(task.getEndTime().toDateTimeToday().getMillis()));
			pst.setString(9, task.getDescription());
			//task review status

			pst.executeUpdate();
			ResultSet generatedKeys = pst.getGeneratedKeys();

			if (null != generatedKeys && generatedKeys.next()) {
				primaryKey = generatedKeys.getInt(1);
				task.setId(primaryKey);
			}
			addTaskReviewStatus(task);
			System.out.println("Data added");
			return primaryKey;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}

	@Override
	public List<Task> getAllTasks() throws DaoException {
		List<Task> taskList = new ArrayList<Task>();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_TASK);
			rs = pst.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				Task task = new Task();

				task.setId(rs.getInt("Task_Id"));
				task.setName(rs.getString("Name"));

				category.setId(rs.getInt("Category_Id"));
				CategoryDao dao = new CategoryDaoImpl();
				category = dao.findById(category);
				task.setCategory(category);

				task.setDeadline(rs.getDate("Deadline"));
				task.setTime(rs.getInt("Time"));
				task.setStartTime(new LocalTime(rs.getTime("Start_Time").getTime()));
				task.setHappyTime(new LocalTime(rs.getTime("Happy_Time").getTime()));
				task.setEndTime(new LocalTime(rs.getTime("End_Time").getTime()));
				task.setDescription(rs.getString("Description"));

				taskList.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		return taskList;
	}

	@Override
	public boolean deleteTaskById(Task task) throws DaoException {
		try {
			System.out.println("deleting task: " + task);
			con = getConnection();
			pst = con.prepareStatement(DbConstants.DELETE_TASK);
			pst.setInt(1, task.getId());
			pst.executeUpdate();
			System.out.println("Record delete");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}


	@Override
	public void updateTask(Task task) throws DaoException {

		try {
			System.out.println("updating task: " + task);
			con = getConnection();
			pst = con.prepareStatement(DbConstants.UPDATE_TASK);

			// get Category Id.
			CategoryDao categoryDao = new CategoryDaoImpl();
			Category category = categoryDao.findByName(task.getCategory());
			System.out.println("updating, category id is " + category.getId());
			// Is this correct?
			if (category.getId() == 0) {
				int key = categoryDao.addCategory(category);
				System.out.println("add category, the generated key is ...." + key);
				category.setId(key);
			}

			task.setCategory(category);

			pst.setString(1, task.getName());
			pst.setInt(2, task.getCategory().getId());
			pst.setInt(3, task.getTime());
			pst.setDate(4, new Date(task.getDeadline().getTime()));
			pst.setTime(5,new Time(task.getStartTime().toDateTimeToday().getMillis()));
			pst.setTime(6, new Time(task.getHappyTime().toDateTimeToday().getMillis()));
			pst.setTime(7, new Time(task.getEndTime().toDateTimeToday().getMillis()));
			pst.setString(8, task.getDescription());
			pst.setInt(9, task.getId());

			pst.executeUpdate();
			System.out.println("Data added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}

	@Override
	public Task getTaskById(Task task) throws DaoException {

		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_TASK_BY_ID);
			pst.setInt(1, task.getId());
			rs = pst.executeQuery();

			while (rs.next()) {
				task.setId(rs.getInt("Task_Id"));
				task.setName(rs.getString("Name"));

				Category category = new Category();
				category.setId(rs.getInt("Category_Id"));
				CategoryDao dao = new CategoryDaoImpl();
				category = dao.findById(category);
				task.setCategory(category);

				task.setStartTime(new LocalTime(rs.getTime("Start_Time").getTime()));
				task.setHappyTime(new LocalTime(rs.getTime("Happy_Time").getTime()));
				task.setEndTime(new LocalTime(rs.getTime("End_Time").getTime()));

				task.setDeadline(rs.getDate("Deadline"));
				task.setTime(rs.getInt("Time"));
				task.setDescription(rs.getString("Description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		System.out.println("get task by id!");
		return task;
	}

	@Override
	public TaskReviewStatus getTaskReviewStatus(Task task) throws DaoException {
		TaskReviewStatus trs =new TaskReviewStatus();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_TASK_REVIEW_STATUS_BY_ID);
			pst.setInt(1, task.getId());
			rs = pst.executeQuery();

			while (rs.next()) {
				trs.setId(rs.getInt("Id"));
				trs.setTaskId(rs.getInt("Task_Id"));
				trs.setName(task.getName());
				trs.setTenMinutes(rs.getInt("10_minutes"));
				trs.setTwenntyFourHours(rs.getInt("24_hours"));
				trs.setOneWeek(rs.getInt("1_week"));
				trs.setOneMonth(rs.getInt("1_month"));
				trs.setTwoMonth(rs.getInt("2_month"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		System.out.println("get task_review_status by id!");
		return trs;
	}

	@Override
	public void updateTaskReviewStatus(TaskReviewStatus trs) throws DaoException {
		try {
			System.out.println("updating task: " + trs);
			con = getConnection();
			pst = con.prepareStatement(DbConstants.UPDATE_TASK_REVIEW_STATUS);

			pst.setInt(1, trs.getTenMinutes());
			pst.setInt(2, trs.getTwenntyFourHours());
			pst.setInt(3, trs.getOneWeek());
			pst.setInt(4, trs.getOneMonth());
			pst.setInt(5,trs.getTwoMonth());
			pst.setInt(6,trs.getTaskId());

			pst.executeUpdate();
			System.out.println("TaskReviewStatus updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}

	@Override
	public int addTaskReviewStatus(Task task) throws DaoException {
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.INSERT_TASK_REVIEW_STATUS, Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1,task.getId());
			pst.setInt(2, 1);
			pst.setInt(3, 1);
			pst.setInt(4, 1);
			pst.setInt(5, 1);
			pst.setInt(6,1);

			pst.executeUpdate();
			ResultSet generatedKeys = pst.getGeneratedKeys();

			if (null != generatedKeys && generatedKeys.next()) {
				int primaryKey = generatedKeys.getInt(1);
				return primaryKey;
			}
			System.out.println("Data added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		return -1;
	}

}
