package carrental.service;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

	public static List<String> getSpecimenTypeList() {
		List<String> specimenTypeList = new ArrayList<String>();
		specimenTypeList.add("-- Select a specimen type --");
		specimenTypeList.add("Amphibians");
		specimenTypeList.add("Arthropods");
		specimenTypeList.add("Birds");
		specimenTypeList.add("Mammals");
		specimenTypeList.add("Reptiles");

		return specimenTypeList;
	}

	public static List<String> getSpecimenNameList(String specimen) {
		List<String> specimenNameList = new ArrayList<String>();

		if (specimen.equals("Amphibians")) {
			specimenNameList.add("Caecilian");
			specimenNameList.add("Frog");
			specimenNameList.add("Salamander");
		} else if (specimen.equals("Arthropods")) {
			specimenNameList.add("Centipede");
			specimenNameList.add("Shrimp");
			specimenNameList.add("Crab");
		} else if (specimen.equals("Birds")) {
			specimenNameList.add("Crow");
			specimenNameList.add("Eagle");
			specimenNameList.add("Hawk");
		} else if (specimen.equals("Mammals")) {
			specimenNameList.add("Human");
			specimenNameList.add("Bear");
			specimenNameList.add("Whale");
		} else if (specimen.equals("Reptiles")) {
			specimenNameList.add("Crocodile");
			specimenNameList.add("Lizard");
			specimenNameList.add("Snake");
		}
		return specimenNameList;
	}

}
