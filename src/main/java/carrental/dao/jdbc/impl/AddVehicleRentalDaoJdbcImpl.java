package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import carrental.constants.DbConstants;
import carrental.dao.AddVehicleRentalDao;
import carrental.exceptions.DaoException;
import carrental.model.VehicleRental;

/**
 * @author M1017325
 *
 */

public class AddVehicleRentalDaoJdbcImpl extends BaseDaoJdbcImpl implements
		AddVehicleRentalDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public void addVehicleRental(VehicleRental r) throws DaoException {
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.ADD_BOOKING_RENTAL_VEHICLE);
			pst.setString(1, r.getCustomerName());
			pst.setString(2, r.getCategory());
			pst.setString(3, r.getRegistrationNumber());
			pst.setDate(4, new Date(r.getBookedFrom().getTime()));
			pst.setDate(5, new Date(r.getBookedTo().getTime()));
			pst.setInt(6, r.getTotalRent());
			pst.setString(7, r.getPaymentStatus());
			pst.executeUpdate();
			System.out.println("Data added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}
}
