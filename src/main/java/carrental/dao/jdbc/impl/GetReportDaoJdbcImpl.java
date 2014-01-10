package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.GetReportDao;
import carrental.exceptions.DaoException;
import carrental.model.ReportEntry;

/**
 * @author M1017325
 *
 */

public class GetReportDaoJdbcImpl extends BaseDaoJdbcImpl implements
		GetReportDao {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public List<ReportEntry> getReport() throws DaoException {
		List<ReportEntry> reportList = new ArrayList<ReportEntry>();
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(DbConstants.GET_REPORT);
			while (rs.next()) {
				ReportEntry r = new ReportEntry();
				r.setVehicleType(rs.getString("Vehicle Type"));
				r.setTotalNumOfVehicles(rs.getInt("Total No of Vehicles"));
				r.setTotalNumOfVehiclesRent(rs
						.getInt("Total No of Vehicles Rented"));
				r.setTotalRentEarned(rs.getInt("Total Rent Earned"));
				System.out.println(r.getTotalRentEarned());
				reportList.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, null, st, rs);
		}
		return reportList;
	}

}
