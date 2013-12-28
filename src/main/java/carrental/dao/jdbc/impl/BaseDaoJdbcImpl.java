package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import carrental.dao.BaseDao;
import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;





/**
 * @author M1017325
 *
 */


public class BaseDaoJdbcImpl implements BaseDao  {

	Connection con=null;
	@Override
	public Connection getConnection() throws ApplicationException, DaoException {
		String driver=Messages.getString("BaseDaoJdbcImpl.driver"); //$NON-NLS-1$
		String url=Messages.getString("BaseDaoJdbcImpl.url"); //$NON-NLS-1$
		String user=Messages.getString("BaseDaoJdbcImpl.user"); //$NON-NLS-1$
		String password=Messages.getString("BaseDaoJdbcImpl.password"); //$NON-NLS-1$
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(),e);
		}
		return con;

	}
	@Override
	public void closeConnection(Connection con) throws ApplicationException{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ApplicationException(e.getMessage(),e);
			}
		}
	}
	@Override
	public void closePreparedStatement(PreparedStatement pst) throws ApplicationException{
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
			    e.printStackTrace();
				throw new ApplicationException(e.getMessage(),e);
			}
		}
	}
	@Override
	public void closeStatement(Statement st) throws ApplicationException{
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ApplicationException(e.getMessage(),e);
			}
		}
	}
	@Override
	public void closeResultSet(ResultSet rs) throws ApplicationException{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ApplicationException(e.getMessage(),e);
			}
		}
	}

}
