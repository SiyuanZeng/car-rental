package carrental.dao;

import java.util.List;

import carrental.entity.Vehicle;
import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface GetCategoryDao {

	List<Vehicle> getAllCategory() throws DaoException;

}
