package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.GetCategoryDao;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;



/**
 * @author M1017325
 *
 */


public class GetCategoryDaoJdbcImpl extends BaseDaoJdbcImpl implements GetCategoryDao {

	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	@Override
	public List<Vehicle> getAllCategory() throws DaoException {
		List<Vehicle> vehicle=new ArrayList<Vehicle>();
		try{
			con=getConnection();
			st=con.createStatement();
			rs=st.executeQuery(DbConstants.GET_CATEGORY);
			while(rs.next()){
				Vehicle v=new Vehicle();
				v.setRegistrationNumber(rs.getString("registration_no"));
				v.setCategory(rs.getString("category"));
				v.setDailyRent(rs.getInt("daily_rent"));
				vehicle.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(),e);
		}
		return vehicle;
	}

}
