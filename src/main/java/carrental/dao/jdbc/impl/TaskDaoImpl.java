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
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Category;
import carrental.model.Task;

/**
 * @author M1017325
 *
 */

public class TaskDaoImpl extends BaseDaoJdbcImpl implements TaskDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

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
			try {
				closePreparedStatement(pst);
				closeResultSet(rs);
				closeConnection(con);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		return -1;
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
			try {
				closePreparedStatement(pst);
				closeResultSet(rs);
				closeConnection(con);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
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
			try {
				closePreparedStatement(pst);
				closeResultSet(rs);
				closeConnection(con);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}

	// I think this is the same as add.

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
				System.out.println("add category, the generated key is ...."
						+ key);
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
			try {
				closePreparedStatement(pst);
				closeResultSet(rs);
				closeConnection(con);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
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
			try {
				closePreparedStatement(pst);
				closeResultSet(rs);
				closeConnection(con);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		System.out.println("get task by id!");
		return task;
	}

}
