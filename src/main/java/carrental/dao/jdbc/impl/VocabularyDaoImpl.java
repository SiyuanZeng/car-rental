package carrental.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carrental.constants.DbConstants;
import carrental.dao.VocabularyDao;
import carrental.exceptions.DaoException;
import carrental.model.TaskReviewStatus;
import carrental.model.VocabularyCategory;
import carrental.model.VocabularyForm;

/**
 * @author M1017325
 *
 */

public class VocabularyDaoImpl extends WorkItemDaoImpl implements VocabularyDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public int addVocabulary(VocabularyForm vocabulary) throws DaoException {
		try {
			//get the maps
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_VOCABULARY_CATEGORY);
			rs = pst.executeQuery();

			//add vocabulary_vocabulary_category_maps    -->
			Map<String, Integer> vocabularyCategoriesMap = new HashMap<String, Integer>();

			while (rs.next()) {
				vocabularyCategoriesMap.put(rs.getString("category"), rs.getInt("id"));
			}

			List<String> categoriesList = vocabulary.getVocabularyCategory().getCategoriesList();


			// vocabulary_category_maps

			pst = con.prepareStatement(DbConstants.INSERT_VOCABULARY_VOCABULARY_CATEGORY_MAPS,Statement.RETURN_GENERATED_KEYS);

			int pos =1;

			System.out.println(categoriesList);

			System.out.println("get number: "+vocabularyCategoriesMap.get("Adjective"));

			for (String category : categoriesList) {
				pst.setInt(pos++, vocabularyCategoriesMap.get(category));
			}

			while(pos<=4){
				pst.setNull(pos++, java.sql.Types.INTEGER);
			}


			pst.executeUpdate();
			ResultSet generatedKeys = pst.getGeneratedKeys();

			int categoryMapsId = -1;
			if (null != generatedKeys && generatedKeys.next()) {
				categoryMapsId = generatedKeys.getInt(1);
			}


			//add vocabulary
			pst = con.prepareStatement(DbConstants.INSERT_VOCABULARY,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, categoryMapsId);
			pst.setString(2, vocabulary.getName());
			pst.setString(3, vocabulary.getEtymology());
			pst.setString(4, vocabulary.getVariedFormSubject());
			pst.setString(5, vocabulary.getVariedFormAdverb());
			pst.setString(6, vocabulary.getVariedFormVerb());
			pst.setString(7, vocabulary.getVariedFormAdjective());
			pst.setString(8, vocabulary.getVariedFormNoun());
			pst.setString(9, vocabulary.getSynonym());
			pst.setString(10, vocabulary.getAntonym());
			pst.setString(11, vocabulary.getNote());
			pst.setString(12, vocabulary.getExample());
			pst.setString(13, vocabulary.getPersonalExperience());
			pst.setString(14, vocabulary.getWriting());
			pst.setString(15, vocabulary.getMemoryTag());

			pst.executeUpdate();
			generatedKeys = pst.getGeneratedKeys();


			int vocabularyId=-1;
			if (null != generatedKeys && generatedKeys.next()) {
				vocabularyId = generatedKeys.getInt(1);
			}

			//add review_status

			pst = con.prepareStatement(DbConstants.INSERT_TASK_REVIEW_STATUS, Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1,vocabularyId);
			pst.setInt(2, 1);
			pst.setInt(3, 1);
			pst.setInt(4, 1);
			pst.setInt(5, 1);
			pst.setInt(6,1);

			pst.executeUpdate();

			return vocabularyId;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
	}


	@Override
	public List<VocabularyForm> getAllVocabularies() throws DaoException {
		List<VocabularyForm> vocabularyList = new ArrayList<VocabularyForm>();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_VOCABULARY);
			rs = pst.executeQuery();

			while (rs.next()) {
				VocabularyForm vocabulary = new VocabularyForm();
				vocabulary.setId(rs.getInt("id"));
				//Category
				VocabularyCategory vocabularyCategory = new VocabularyCategory();
				vocabularyCategory.setId(rs.getInt("category_id"));
				vocabularyCategory.setCategoriesList(getCategoryForVocabulary(vocabulary));
				vocabulary.setVocabularyCategory(vocabularyCategory);
				//Review Status
				vocabulary.setTaskReviewStatus(getTaskReviewStatus(vocabulary));


				vocabulary.setName(rs.getString("word"));
				vocabulary.setEtymology(rs.getString("etymology"));
				vocabulary.setVariedFormSubject(rs.getString("subject_form"));
				vocabulary.setVariedFormAdverb(rs.getString("adverb_form"));
				vocabulary.setVariedFormVerb(rs.getString("verb_form"));
				vocabulary.setVariedFormAdjective(rs.getString("adjective_form"));
				vocabulary.setVariedFormNoun(rs.getString("noun_form"));
				vocabulary.setSynonym(rs.getString("synonym"));
				vocabulary.setAntonym(rs.getString("antonym"));
				vocabulary.setNote(rs.getString("note"));
				vocabulary.setExample(rs.getString("example"));
				vocabulary.setPersonalExperience(rs.getString("personal_experience"));
				vocabulary.setWriting(rs.getString("writing"));
				vocabulary.setMemoryTag(rs.getString("memory_tag"));

				vocabularyList.add(vocabulary);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		return vocabularyList;
	}



	public List<String> getCategoryForVocabulary(VocabularyForm vocabulary) throws DaoException {
		List<String> categoryList = new ArrayList<String>();
		try {
			con = getConnection();
			pst = con.prepareStatement(DbConstants.SELECT_CATEGORY_FOR_VOCABULARY);
			pst.setInt(1, vocabulary.getCategoryId());
			rs = pst.executeQuery();

			while (rs.next()) {
				categoryList.add(rs.getString("category_1"));
				categoryList.add(rs.getString("category_2"));
				categoryList.add(rs.getString("category_3"));
				categoryList.add(rs.getString("category_4"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		} finally {
			close(con, pst, null, rs);
		}
		return categoryList;
	}

}
