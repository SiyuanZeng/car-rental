package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;
import carrental.model.WorkItem;

public interface TaskDao {
	int addTask(Task task) throws DaoException;
	List<Task> getAllTasks() throws DaoException;
	Task getTaskById(Task task) throws DaoException;
	boolean deleteTaskById(WorkItem task) throws DaoException;
	void updateTask(Task task) throws DaoException;

	//status
	TaskReviewStatus getTaskReviewStatus(WorkItem task)throws DaoException;

	void updateTaskReviewStatus(TaskReviewStatus taskReviewStatus) throws DaoException;

	int addTaskReviewStatus(WorkItem task) throws DaoException;
}
