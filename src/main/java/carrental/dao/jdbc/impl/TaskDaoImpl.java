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
import carrental.dao.TaskCategoryDao;
import carrental.dao.TaskDao;
import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.TaskCategory;
import carrental.model.TaskReviewStatus;
import carrental.model.WorkItem;

/**
 * @author M1017325
 *
 */

public class TaskDaoImpl extends WorkItemDaoImpl implements TaskDao {

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

			// get TaskCategory Id.
			TaskCategoryDao categoryDao = new TaskCategoryDaoImpl();
			TaskCategory category = categoryDao.findByName(task.getTaskCategory());
			System.out.println("updating, category id is " + category.getId());
			// Is this correct?
			if (category.getId() == 0) {
				int key = categoryDao.addTaskCategory(category);
				System.out.println("add category, the generated key is ...."
						+ key);
				category.setId(key);
			}
			task.setTaskCategory(category);

			pst.setInt(1, category.getId());
			pst.setString(2, task.getName());
			pst.setDate(3, new Date(task.getDeadline().getTime()));
			pst.setTime(4, new Time(task.getStartTime().toDateTimeToday()
					.getMillis()));
			pst.setInt(5, task.getTime());
			pst.setTime(6, new Time(task.getHappyTime().toDateTimeToday()
					.getMillis()));
			pst.setTime(7, new Time(task.getEndTime().toDateTimeToday()
					.getMillis()));
			pst.setString(8, task.getDescription());
			// task review status

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
				TaskCategory category = new TaskCategory();
				Task task = new Task();

				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));

				category.setId(rs.getInt("category_id"));
				TaskCategoryDao dao = new TaskCategoryDaoImpl();
				category = dao.findById(category);
				task.setTaskCategory(category);

				task.setDeadline(rs.getDate("deadline"));
				task.setTime(rs.getInt("time"));
				task.setStartTime(new LocalTime(rs.getTime("start_time")
						.getTime()));
				task.setHappyTime(new LocalTime(rs.getTime("happy_time")
						.getTime()));
				task.setEndTime(new LocalTime(rs.getTime("end_time").getTime()));
				task.setDescription(rs.getString("description"));

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
	public boolean deleteTaskById(WorkItem task) throws DaoException {
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

			// get TaskCategory Id.
			TaskCategoryDao categoryDao = new TaskCategoryDaoImpl();
			TaskCategory category = categoryDao.findByName(task
					.getTaskCategory());
			System.out.println("updating, category id is " + category.getId());
			// Is this correct?
			if (category.getId() == 0) {
				int key = categoryDao.addTaskCategory(category);
				System.out.println("add category, the generated key is ...."
						+ key);
				category.setId(key);
			}

			task.setTaskCategory(category);

			pst.setString(1, task.getName());
			pst.setInt(2, task.getTaskCategory().getId());
			pst.setInt(3, task.getTime());
			pst.setDate(4, new Date(task.getDeadline().getTime()));
			pst.setTime(5, new Time(task.getStartTime().toDateTimeToday()
					.getMillis()));
			pst.setTime(6, new Time(task.getHappyTime().toDateTimeToday()
					.getMillis()));
			pst.setTime(7, new Time(task.getEndTime().toDateTimeToday()
					.getMillis()));
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
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));

				TaskCategory category = new TaskCategory();
				category.setId(rs.getInt("category_id"));
				TaskCategoryDao dao = new TaskCategoryDaoImpl();
				category = dao.findById(category);
				task.setTaskCategory(category);

				task.setStartTime(new LocalTime(rs.getTime("start_time")
						.getTime()));
				task.setHappyTime(new LocalTime(rs.getTime("happy_time")
						.getTime()));
				task.setEndTime(new LocalTime(rs.getTime("end_time").getTime()));

				task.setDeadline(rs.getDate("deadline"));
				task.setTime(rs.getInt("time"));
				task.setDescription(rs.getString("description"));
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

}
