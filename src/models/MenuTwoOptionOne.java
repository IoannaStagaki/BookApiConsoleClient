package models;

import java.io.BufferedReader;

import api.ApiCalls;

public class MenuTwoOptionOne extends MenuItem {

	public MenuTwoOptionOne() {
		this.setTitle("Ανάκτηση λίστας δημοσίων ραφιών χρήστη");

	}

	private String DefaultUserId = "102701940585560677579";

	@Override
	public String userQuestions(BufferedReader scan) throws Exception {
		System.out.println("\tΠαρακαλώ εισάγετε το ID του χρήστη που επιθυμείτε να δείτε τα δημόσια ράφια.");
		System.out.println("\tΑλλιώς αφήστε κενό και θα βάλουμε εμείς τον χρήστη με αριθμο: " + this.DefaultUserId);
		String userId = scan.readLine();
		if (userId.equals(null) || userId.equals("")) {
			userId = DefaultUserId;
		}
		ApiCalls api = new ApiCalls();
		try {
			UserBookshelves bookshelves = api.GetUserBookshelves(userId);
			bookshelves.getItems().stream().forEach(item -> {
				System.out.println("=============");
				System.out.println(item.toString());
			System.out.println();
			});
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
