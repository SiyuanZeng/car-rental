package carrental.dao;

import carrental.exceptions.DaoException;
import carrental.model.RentalVehicle;


/**
 * @author M1017325
 *
 */

public interface AddBookingRentalVehicleDao {

	void addRentalVehicle(RentalVehicle rV) throws DaoException;

}
