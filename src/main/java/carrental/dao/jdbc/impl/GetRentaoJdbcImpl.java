package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import carrental.constants.DbConstants;
import carrental.dao.GetRentDao;
import carrental.exceptions.DaoException;



/**
 * @author M1017325
 *
 */


public class GetRentaoJdbcImpl extends BaseDaoJdbcImpl implements GetRentDao {

	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Override
	public Integer getRent(String regNo) throws DaoException{
		try{
			con=getConnection();
			pst=con.prepareStatement(DbConstants.GET_RENT);
			pst.setString(1, regNo);
			rs=pst.executeQuery();
			
			try {
				if(rs.next()){
					return rs.getInt("daily_rent");
				}
				else{
					return 0;
				}
			} finally {
				rs.close();
				pst.close();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(),e);
			
		}
	}

}
