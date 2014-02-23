package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;
import carrental.model.WorkItem;

public interface WorkItemDao {
	//status
	TaskReviewStatus getTaskReviewStatus(WorkItem task)throws DaoException;

	void updateTaskReviewStatus(TaskReviewStatus taskReviewStatus) throws DaoException;

	int addTaskReviewStatus(WorkItem task) throws DaoException;
}
