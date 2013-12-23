package carrental.dao;

import java.util.List;

import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;


/**
 * @author M1017325
 *
 */

public interface GetRegNoDao {

	List<Vehicle> getRegNo(String category) throws ApplicationException, DaoException;

}
