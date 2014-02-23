package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.TaskCategory;

public interface TaskCategoryDao {
	List<TaskCategory> getAllTaskCategory() throws DaoException;
	TaskCategory findById(TaskCategory category) throws DaoException;
	int addTaskCategory(TaskCategory category) throws DaoException;
	TaskCategory findByName(TaskCategory category) throws DaoException;
}
