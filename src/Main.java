import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import models.Menu;
import models.MenuItem;
import models.MenuOneOptionOne;
import models.MenuOneOptionThree;
import models.MenuOneOptionTwo;
import models.MenuTwoOptionOne;
import models.MenuTwoOptionThree;
import models.MenuTwoOptionTwo;

public class Main {
	private static Queue<String> LastFiveSearches = new LinkedList<String>();

	private static void addLocalStorage(String term) {
		if (LastFiveSearches.size() == 5) {
			LastFiveSearches.poll();
			LastFiveSearches.add(term);
		} else {
			LastFiveSearches.add(term);
		}
	}

	@SuppressWarnings("serial")
	private static ArrayList<Menu> SetMenuItems() {
		ArrayList<Menu> UserMenus = new ArrayList<Menu>();
		Menu menuOne = new Menu();
		menuOne.setTitle("Αναζήτηση τόμων");
		ArrayList<MenuItem> menuOneMenuItems = new ArrayList<MenuItem>() {
			{
				add(new MenuOneOptionOne());
				add(new MenuOneOptionTwo());
				add(new MenuOneOptionThree());
			}
		};
		menuOne.setMenuItems(menuOneMenuItems);
		Menu menuTwo = new Menu();
		menuTwo.setTitle("Διαχείριση ραφιών");
		ArrayList<MenuItem> menuTwoMenuItems = new ArrayList<MenuItem>() {
			{
				add(new MenuTwoOptionOne());
				add(new MenuTwoOptionTwo());
				add(new MenuTwoOptionThree());

			}
		};
		menuTwo.setMenuItems(menuTwoMenuItems);
		Menu menuThree = new Menu();
		menuThree.setTitle("Έξοδος");

		UserMenus.add(menuOne);
		UserMenus.add(menuTwo);
		UserMenus.add(menuThree);
		return UserMenus;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Menu> UserMenus = SetMenuItems();
//		Scanner Scan = new Scanner(System.in);
		BufferedReader Scan = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;
		while (userInput < 1 || userInput > UserMenus.size()) {
			System.out.println();
			System.out.println("====== Menu ======");
			System.out.println("Παρακαλω επιλέξτε:");
			System.out.println("======      ======");
			System.out.println();

			for (int i = 0; i < UserMenus.size(); i++) {
				System.out.println(MessageFormat.format("{0}. {1}", i + 1, UserMenus.get(i).getTitle()));
			}

			try {
				userInput = Integer.parseInt(Scan.readLine());
				if (userInput < 1 || userInput > UserMenus.size()) {
					System.out.println(
							MessageFormat.format("Παρακαλώ βάλτε μια τιμή μεταξύ 1 και {0}", UserMenus.size()));
				} else {
					switch (userInput) {
					case 1:
						System.out.println("\tΠαρακαλω επιλέξτε: \n");
						Menu menuOne = UserMenus.get(0);
						for (int i = 0; i < menuOne.getMenuItems().size(); i++) {
							System.out.println(MessageFormat.format("\t{0}. {1}", i + 1,
									menuOne.getMenuItems().get(i).getTitle()));
						}
						int menuOneSubmenuChoise = Integer.parseInt(Scan.readLine());
						if (menuOneSubmenuChoise < 1 || menuOneSubmenuChoise > menuOne.getMenuItems().size()) {
							System.out.println(MessageFormat.format("Παρακαλώ βάλτε μια τιμή μεταξύ 1 και {0}",
									menuOne.getMenuItems().size()));
						}
						switch (menuOneSubmenuChoise) {
						case 1:
							String searchTerm = menuOne.getMenuItems().get(0).userQuestions(Scan);
							addLocalStorage(searchTerm);
							userInput = 0;
							break;
						case 2:
							menuOne.getMenuItems().get(1).userQuestions(Scan);
							userInput = 0;
							break;
						case 3:
							menuOne.getMenuItems().get(2).userQuestions(LastFiveSearches);
							userInput = 0;
							break;
						}
						break;
					case 2:
						System.out.println("\tΠαρακαλω επιλέξτε: \n");
						Menu menuTwo = UserMenus.get(1);
						for (int i = 0; i < menuTwo.getMenuItems().size(); i++) {
							System.out.println(MessageFormat.format("\t{0}. {1}", i + 1,
									menuTwo.getMenuItems().get(i).getTitle()));
						}
						int menuTwoSubmenuChoise = Integer.parseInt(Scan.readLine());
						if (menuTwoSubmenuChoise < 1 || menuTwoSubmenuChoise > menuTwo.getMenuItems().size()) {
							System.out.println(MessageFormat.format("Παρακαλώ βάλτε μια τιμή μεταξύ 1 και {0}",
									menuTwo.getMenuItems().size()));
						}
						switch (menuTwoSubmenuChoise) {
						case 1:
							menuTwo.getMenuItems().get(0).userQuestions(Scan);
							userInput = 0;
							break;
						case 2:
							menuTwo.getMenuItems().get(1).userQuestions(Scan);
							userInput = 0;
							break;
						case 3:
							menuTwo.getMenuItems().get(2).userQuestions(Scan);
							userInput = 0;
							break;
						}
						break;
					case 3:
						System.out.println("Ευχαριστούμε αντίο");
						Scan.close();
						System.exit(0);
						break;
					}
				}
			} catch (Exception e) {
				userInput = 0;
			}

		}
	}

}
