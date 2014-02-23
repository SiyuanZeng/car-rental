package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import carrental.constants.DbConstants;
import carrental.dao.WorkItemDao;
import carrental.exceptions.DaoException;
import carrental.model.TaskReviewStatus;
import carrental.model.WorkItem;

/**
 * @author M1017325
 *
 */

public class WorkItemDaoImpl extends BaseDaoJdbcImpl implements WorkItemDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int primaryKey = -1;

		@Override
	public TaskReviewStatus getTaskReviewStatus(WorkItem task)
			throws DaoException {
		TaskReviewStatus trs = new TaskReviewStatus();
		try {
			con = getConnection();
			pst = con
					.prepareStatement(DbConstants.SELECT_TASK_REVIEW_STATUS_BY_ID);
			pst.setInt(1, task.getId());
			rs = pst.executeQuery();

			while (rs.next()) {
				trs.setId(rs.getInt("id"));
				trs.setTaskId(rs.getInt("task_Id"));
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
	public void updateTaskReviewStatus(TaskReviewStatus trs)
			throws DaoException {
		try {
			System.out.println("updating task: " + trs);
			con = getConnection();
			pst = con.prepareStatement(DbConstants.UPDATE_TASK_REVIEW_STATUS);

			pst.setInt(1, trs.getTenMinutes());
			pst.setInt(2, trs.getTwenntyFourHours());
			pst.setInt(3, trs.getOneWeek());
			pst.setInt(4, trs.getOneMonth());
			pst.setInt(5, trs.getTwoMonth());
			pst.setInt(6, trs.getTaskId());

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
	public int addTaskReviewStatus(WorkItem task) throws DaoException {
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.INSERT_TASK_REVIEW_STATUS,
					Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, task.getId());
			pst.setInt(2, 1);
			pst.setInt(3, 1);
			pst.setInt(4, 1);
			pst.setInt(5, 1);
			pst.setInt(6, 1);

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
