package carrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import carrental.exceptions.ApplicationException;
import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface BaseDao {
	public Connection getConnection() throws ApplicationException, DaoException;

	void closeResultSet(ResultSet rs) throws ApplicationException;

	void closeStatement(Statement st) throws ApplicationException;

	void closePreparedStatement(PreparedStatement pst)
			throws ApplicationException;

	void closeConnection(Connection con) throws ApplicationException;
	

}
