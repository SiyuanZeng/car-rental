package carrental.dao;

import carrental.entity.Vehicle;
import carrental.exceptions.DaoException;


public interface AddNewVehicleDao {

	void addNewVehicle(Vehicle v) throws DaoException;

}
