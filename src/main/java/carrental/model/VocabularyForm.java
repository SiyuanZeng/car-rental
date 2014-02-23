package carrental.model;

import java.util.List;

public class VocabularyForm extends WorkItem{
	private String pronouciation;
	private String etymology;
	private VocabularyCategory vocabularyCategory;
	private String variedFormSubject;
	private String variedFormAdverb;
	private String variedFormVerb;
	private String variedFormAdjective;
	private String variedFormNoun;
	private String synonym;
	private String antonym;
	private String note;
	private String example;
	private String personalExperience;
	private String writing;
	private String memoryTag;
	private TaskReviewStatus taskReviewStatus;


	public String getPronouciation() {
		return pronouciation;
	}
	public void setPronouciation(String pronouciation) {
		this.pronouciation = pronouciation;
	}
	public String getEtymology() {
		return etymology;
	}
	public void setEtymology(String etymology) {
		this.etymology = etymology;
	}
	public VocabularyCategory getVocabularyCategory() {
		return vocabularyCategory;
	}
	public void setVocabularyCategory(VocabularyCategory vocabularyCategory) {
		this.vocabularyCategory = vocabularyCategory;
	}
	public String getVariedFormSubject() {
		return variedFormSubject;
	}
	public void setVariedFormSubject(String variedFormSubject) {
		this.variedFormSubject = variedFormSubject;
	}
	public String getVariedFormAdverb() {
		return variedFormAdverb;
	}
	public void setVariedFormAdverb(String variedFormAdverb) {
		this.variedFormAdverb = variedFormAdverb;
	}
	public String getVariedFormVerb() {
		return variedFormVerb;
	}
	public void setVariedFormVerb(String variedFormVerb) {
		this.variedFormVerb = variedFormVerb;
	}
	public String getVariedFormAdjective() {
		return variedFormAdjective;
	}
	public void setVariedFormAdjective(String variedFormAdjective) {
		this.variedFormAdjective = variedFormAdjective;
	}
	public String getVariedFormNoun() {
		return variedFormNoun;
	}
	public void setVariedFormNoun(String variedFormNoun) {
		this.variedFormNoun = variedFormNoun;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	public String getAntonym() {
		return antonym;
	}
	public void setAntonym(String antonym) {
		this.antonym = antonym;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getPersonalExperience() {
		return personalExperience;
	}
	public void setPersonalExperience(String personalExperience) {
		this.personalExperience = personalExperience;
	}
	public String getWriting() {
		return writing;
	}
	public void setWriting(String writing) {
		this.writing = writing;
	}
	public String getMemoryTag() {
		return memoryTag;
	}
	public void setMemoryTag(String memoryTag) {
		this.memoryTag = memoryTag;
	}

	public TaskReviewStatus getTaskReviewStatus() {
		return taskReviewStatus;
	}
	public void setTaskReviewStatus(TaskReviewStatus taskReviewStatus) {
		this.taskReviewStatus = taskReviewStatus;
	}
	@Override
	public String toString() {
		return "VocabularyForm [pronouciation="
				+ pronouciation + ", etymology=" + etymology
				+ ", vocabularyCategory=" + vocabularyCategory + ", variedFormSubject="
				+ variedFormSubject + ", variedFormAdverb=" + variedFormAdverb
				+ ", variedFormVerb=" + variedFormVerb
				+ ", variedFormAdjective=" + variedFormAdjective
				+ ", variedFormNoun=" + variedFormNoun + ", synonym=" + synonym
				+ ", antonym=" + antonym + ", note=" + note + ", example="
				+ example + ", personalExperience=" + personalExperience
				+ ", writing=" + writing + ", memoryTag=" + memoryTag + "]";
	}





}
