package models;

import java.io.BufferedReader;

import api.ApiCalls;

public class MenuTwoOptionTwo extends MenuItem {

	private String DefaultUserId = "102701940585560677579";

	public MenuTwoOptionTwo() {
		this.setTitle("Προβολή πληροφοριών για δημόσιο ράφι άλλου χρήστη");
	}

	@Override
	public String userQuestions(BufferedReader scan) throws Exception {
		System.out.println("\tΠαρακαλώ εισάγετε το ID του χρήστη που επιθυμείτε να δείτε τα δημόσια ράφια του.");
		System.out.println("\tΑλλιώς αφήστε 'ENTER' και θα θα μπεί αυτόματα ο χρήστη με αριθμό: " + this.DefaultUserId);
		String userId = scan.readLine();
		if (userId.equals(null) || userId.equals("")) {
			userId = DefaultUserId;
		}
		System.out.println("\tΠαρακαλώ εισάγετε το ID του δημοσίου ραφιού:");
		String bookshelveId = scan.readLine();
		ApiCalls api = new ApiCalls();

		try {
			Bookshelve bookhelve = api.GetUserBookshelveInfo(userId, bookshelveId);
			System.out.println(bookhelve.toString());
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
