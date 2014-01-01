package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Task;

public interface TaskDao {
	void addTask(Task task) throws DaoException;
	List<Task> getAllTasks() throws DaoException;
}
