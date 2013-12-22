package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import carrental.constants.DbConstants;
import carrental.dao.AddNewVehicleDao;
import carrental.entity.Vehicle;
import carrental.exceptions.DaoException;



public class AddNewVehicleDaoJdbcImpl extends BaseDaoJdbcImpl implements
		AddNewVehicleDao {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public void addNewVehicle(Vehicle v) throws DaoException {
		try{
			con=getConnection();
			pst=con.prepareStatement(DbConstants.ADD_VEHICLE);
			pst.setString(1, v.getRegistrationNumber());
			pst.setString(2, v.getFuelType());
			pst.setInt(3, v.getMileage());
			pst.setString(4, v.getCategory());
			pst.setInt(5,v.getDailyRent());
			
			pst.executeUpdate();
			System.out.println("Data added");
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(),e);
			
		}
		
	}
}