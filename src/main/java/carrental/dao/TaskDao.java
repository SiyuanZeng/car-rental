package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;

public interface TaskDao {
	int addTask(Task task) throws DaoException;
	List<Task> getAllTasks() throws DaoException;
	Task getTaskById(Task task) throws DaoException;
	boolean deleteTaskById(Task task) throws DaoException;
	void updateTask(Task task) throws DaoException;

	//status
	TaskReviewStatus getTaskReviewStatus(Task task)throws DaoException;

	void updateTaskReviewStatus(TaskReviewStatus taskReviewStatus) throws DaoException;

	int addTaskReviewStatus(Task task) throws DaoException;
}
