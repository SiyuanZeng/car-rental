package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import carrental.constants.DbConstants;
import carrental.dao.CategoryDao;
import carrental.exceptions.DaoException;
import carrental.model.Category;

/**
 * @author M1017325
 *
 */

public class CategoryDaoImpl extends BaseDaoJdbcImpl implements CategoryDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public List<Category> getAllCategory() throws DaoException {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_CATEGORY);
			rs = pst.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("Category_Id"));
				category.setName(rs.getString("Name"));
				categoryList.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		return categoryList;
	}

	@Override
	public int addCategory(Category category) throws DaoException {
		// TODO Auto-generated method stub
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.INSERT_CATEGORY,
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, category.getId());
			pst.setString(2, category.getName());

			pst.executeUpdate();

			ResultSet generatedKeys = pst.getGeneratedKeys();

			if (null != generatedKeys && generatedKeys.next()) {
				int primaryKey = generatedKeys.getInt(1);
				return primaryKey;
			}
			System.out.println("Data added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);

		}
		return 0;
	}

	@Override
	public Category findById(int categoryId) throws DaoException {
		Category category = new Category();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_CATEGORY_BY_ID);
			pst.setInt(1, categoryId);
			rs = pst.executeQuery();

			while (rs.next()) {
				category.setName(rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		return category;
	}

}
