package carrental.dao;

import java.util.List;

import carrental.exceptions.DaoException;
import carrental.model.VocabularyForm;

public interface VocabularyDao {
	int addVocabulary(VocabularyForm Vocabulary) throws DaoException;
	List<VocabularyForm> getAllVocabularies() throws DaoException;
	List<String> getCategoryForVocabulary(VocabularyForm vocabulary) throws DaoException;
}
