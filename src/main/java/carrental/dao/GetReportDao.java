package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.ReportEntry;


/**
 * @author M1017325
 *
 */

public interface GetReportDao {
	List<ReportEntry> getReport() throws DaoException;
}
