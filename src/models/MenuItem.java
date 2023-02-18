package models;

import java.io.BufferedReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Queue;

public class MenuItem {

	public MenuItem(String title) {
		super();
		Title = title;

	}

	public MenuItem() {
		super();

	}

	public void userQuestions() {

	}

	public String userQuestions(BufferedReader Scan) throws Exception {
		return null;
	}

	public void userQuestions(Queue<String> queue) {

	}

	protected int validateAndReturnInput(ArrayList<String> inputs, String question, BufferedReader scan) {
		int choise = -1;
		String strChoise = null;
		String message = MessageFormat.format("\tΕπιλέξτε μεταξύ 1 και {0}", inputs.size());

		while (choise < 0 || choise > inputs.size()) {
			try {

				if (choise < 0 || choise > inputs.size()) {
					System.out.println("\t" + question);
					System.out.println(message);
				}

				for (int i = 0; i < inputs.size(); i++) {
					System.out.println(MessageFormat.format("\t{0}. {1}", i + 1, inputs.get(i)));
				}

				strChoise = scan.readLine();
				choise = Integer.parseInt(strChoise);

			} catch (Exception e) {
				choise = -1;
			}
		}
		return choise - 1;
	}

	private String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
}
