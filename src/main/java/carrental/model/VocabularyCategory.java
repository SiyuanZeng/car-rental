package carrental.model;

import java.util.List;

public class VocabularyCategory extends Category {
	private List<String> categoriesList;

	public List<String> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<String> categoriesList) {
		this.categoriesList = categoriesList;
	}

	@Override
	public String toString() {
		return "VocabularyCategory [categoriesList=" + categoriesList + "]";
	}


}
