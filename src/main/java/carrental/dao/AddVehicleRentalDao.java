package carrental.dao;

import carrental.exceptions.DaoException;
import carrental.model.VehicleRental;


/**
 * @author M1017325
 *
 */

public interface AddVehicleRentalDao {

	void addVehicleRental(VehicleRental rV) throws DaoException;

}
