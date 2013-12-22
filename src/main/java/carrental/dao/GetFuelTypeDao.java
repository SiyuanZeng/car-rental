package carrental.dao;

import java.util.List;

import carrental.entity.Vehicle;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface GetFuelTypeDao {

	List<Vehicle> getFuelType() throws ApplicationException, DaoException;

}
