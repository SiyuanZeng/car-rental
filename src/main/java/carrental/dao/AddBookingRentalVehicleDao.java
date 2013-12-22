package carrental.dao;

import carrental.entity.RentalVehicle;
import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface AddBookingRentalVehicleDao {

	void addRentalVehicle(RentalVehicle rV) throws DaoException;

}
