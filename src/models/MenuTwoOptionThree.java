package models;

import java.io.BufferedReader;

import api.ApiCalls;

public class MenuTwoOptionThree extends MenuItem {

	private String DefaultUserId = "102701940585560677579";

	public MenuTwoOptionThree() {
		this.setTitle("Ανάκτηση περιεχομένων δημόσιου ραφιού άλλου χρήστη");
	}

	@Override
	public String userQuestions(BufferedReader scan) throws Exception {
		System.out.println("\tΠαρακαλώ εισάγετε το ID του χρήστη που επιθυμείτε να δείτε τα δημόσια ράφια.");
		System.out.println("\tΑλλιώς αφήστε 'ENTER' και θα μπεί αυτόματα ο χρήστη με αριθμό: " + this.DefaultUserId);
		String userId = scan.readLine();
		if (userId.equals(null) || userId.equals("")) {
			userId = DefaultUserId;
		}
		System.out.println("\tΠαρακαλώ εισάγετε το ID του δημοσίου ραφιού:");
		String bookshelveId = scan.readLine();
		ApiCalls api = new ApiCalls();

		try {
			Volumes volumes = api.GetUserBookshelveVolumes(userId, bookshelveId);
			volumes.getItems().stream().forEach(item -> {
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
