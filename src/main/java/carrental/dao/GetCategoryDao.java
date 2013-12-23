package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.Vehicle;


/**
 * @author M1017325
 *
 */

public interface GetCategoryDao {

	List<Vehicle> getAllCategory() throws DaoException;

}
