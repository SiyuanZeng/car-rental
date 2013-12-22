package carrental.dao;

import java.util.List;

import carrental.entity.ReportEntry;
import carrental.exceptions.DaoException;


/**
 * @author M1017325
 *
 */

public interface GetReportDao {
	List<ReportEntry> getReport() throws DaoException;
}
