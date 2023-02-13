package models;

import java.util.Scanner;

import api.ApiCalls;

public class MenuTwoOptionTwo extends MenuItem {

	private String DefaultUserId = "102701940585560677579";

	public MenuTwoOptionTwo() {
		this.setTitle("Προβολή πληροφοριών για δημόσιο ράφι χρήστη");
	}

	@Override
	public void userQuestions(Scanner scan) {
		System.out.println("\tΠαρακαλώ εισάγετε το ID του χρήστη που επιθυμείτε να δείτε τα δημόσια ράφια.");
		System.out.println("\tΑλλιώς αφήστε κενό και θα βάλουμε εμείς τον χρήστη με αριθμο: " + this.DefaultUserId);
		String userId = scan.nextLine();
		if (userId == null || userId == "") {
			userId = DefaultUserId;
		}
		System.out.println("\tΠαρακαλώ εισάγετε το ID του δημοσίου ραφιού:");
		String bookshelveId = scan.nextLine();
		ApiCalls api = new ApiCalls();

		try {
			Bookshelve bookhelve = api.GetUserBookshelveInfo(userId, bookshelveId);
			System.out.println(bookhelve.toString());

		} catch (Exception e) {

		}
	}

}
