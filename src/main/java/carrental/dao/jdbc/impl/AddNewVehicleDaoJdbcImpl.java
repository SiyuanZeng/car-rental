package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import carrental.constants.DbConstants;
import carrental.dao.AddNewVehicleDao;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;



public class AddNewVehicleDaoJdbcImpl extends BaseDaoJdbcImpl implements
		AddNewVehicleDao {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public void addNewVehicle(Vehicle v) throws DaoException {
		try{
			con=getConnection();
			pst=con.prepareStatement(DbConstants.INSERT_VEHICLE);
			pst.setString(1, v.getRegistrationNumber());
			pst.setString(2, v.getFuelType());
			pst.setString(3, v.getManufacturer());
			pst.setInt(4, v.getMileage());
			pst.setString(5, v.getCategory());
			pst.setInt(6,v.getDailyRent());
			pst.setString(7,v.getDescription());
			
			pst.executeUpdate();
			System.out.println("Data added");
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(),e);
			
		}
		
	}
}