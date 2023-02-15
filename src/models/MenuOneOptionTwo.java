package models;

import java.util.Scanner;

import api.ApiCalls;

public class MenuOneOptionTwo extends MenuItem {

	public MenuOneOptionTwo() {
		this.setTitle("Προβολή πληροφοριών για συγκεκριμένο τόμο");
	}

	@Override
	public String userQuestions(Scanner scan) throws Exception {

		System.out.println("Παρακαλώ εισάγετε το ID του τόμου:");
		String volumeId = scan.next();
		
		ApiCalls api = new ApiCalls();
		try {
			Item volumeInfo = api.GetVolumeInfo(volumeId);
			System.out.println("");
			System.out.println(volumeInfo.toString());
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
