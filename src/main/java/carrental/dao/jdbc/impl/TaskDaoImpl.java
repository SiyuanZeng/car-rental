package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.CategoryDao;
import carrental.dao.TaskDao;
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
	public void addTask(Task task) throws DaoException {
		// TODO Auto-generated method stub
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.INSERT_TASK);

			int categoryId = new CategoryDaoImpl().addCategory(task.getCategory());

			pst.setString(1, null);
			pst.setInt(2, categoryId);
			pst.setString(3, task.getName());
			pst.setDate(4, new Date(task.getDeadline().getTime()));
			pst.setInt(5, task.getTime());
			pst.setString(6, task.getDescription());

			pst.executeUpdate();
			System.out.println("Data added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public List<Task> getAllTasks() throws DaoException {
		// TODO Auto-generated method stub
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

				CategoryDao dao = new CategoryDaoImpl();
				category = dao.findById(rs.getInt("Category_Id"));
				task.setCategory(category);

				task.setDeadline(rs.getDate("Deadline"));
				task.setTime(rs.getInt("Time"));
				task.setDescription(rs.getString("Description"));

				taskList.add(task);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		return taskList;
	}

}
