package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.GetRegNoDao;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;
import carrental.model.Vehicle;


/**
 * @author M1017325
 *
 */


public class GetRegNoDaoJdbcImpl extends BaseDaoJdbcImpl implements GetRegNoDao {

	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public List<Vehicle> getRegNo(String c) throws ApplicationException, DaoException {
		List<Vehicle> vehicle=new ArrayList<Vehicle>();
		try{
			con=getConnection();
			pst=con.prepareStatement(DbConstants.GET_REG_NO);
			pst.setString(1, c);
			rs=pst.executeQuery();
			while(rs.next()){
				Vehicle v=new Vehicle();
				v.setRegistrationNumber(rs.getString("registration_no"));
				vehicle.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return vehicle;
	}

}
