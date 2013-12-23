package carrental.dao;

import carrental.exceptions.DaoException;
import carrental.model.Vehicle;


public interface AddNewVehicleDao {

	void addNewVehicle(Vehicle v) throws DaoException;

}
