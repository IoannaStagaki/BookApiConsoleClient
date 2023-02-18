package models;

import java.io.BufferedReader;

import api.ApiCalls;

public class MenuOneOptionTwo extends MenuItem {

	public MenuOneOptionTwo() {
		this.setTitle("Προβολή πληροφοριών για συγκεκριμένο τόμο");
	}

	@Override
	public String userQuestions(BufferedReader scan) throws Exception {

		System.out.println("Παρακαλώ εισάγετε το ID του τόμου:");
		String volumeId = scan.readLine();
		
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
