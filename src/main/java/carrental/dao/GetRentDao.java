package carrental.dao;

import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface GetRentDao {

	Integer getRent(String regNo) throws DaoException;

}
