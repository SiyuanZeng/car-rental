package carrental.dao;

import java.util.List;

import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;


/**
 * @author M1017325
 *
 */

public interface GetFuelTypeDao {

	List<Vehicle> getFuelType() throws ApplicationException, DaoException;

}
