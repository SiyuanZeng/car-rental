package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.GetFuelTypeDao;
import carrental.entity.Vehicle;
import carrental.exceptions.DaoException;



public class GetFuelTypeDaoJdbcImpl extends BaseDaoJdbcImpl implements GetFuelTypeDao {

	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	@Override
	public List<Vehicle> getFuelType() throws DaoException {
		List<Vehicle> vehicle=new ArrayList<Vehicle>();
		try{
			con=getConnection();
			st=con.createStatement();
			rs=st.executeQuery(DbConstants.GET_FUEL_TYPE);
			while(rs.next()){
				Vehicle v=new Vehicle();
				v.setFuelType(rs.getString("fuel_type"));
				vehicle.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(),e);
		}
		return vehicle;
	}

}
