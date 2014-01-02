package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Category;

public interface CategoryDao {
	List<Category> getAllCategory() throws DaoException;
	Category findById(Category category) throws DaoException;
	int addCategory(Category category) throws DaoException;
	Category findByName(Category category) throws DaoException;
}
