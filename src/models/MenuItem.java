package models;

import java.util.Queue;
import java.util.Scanner;

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


	public String userQuestions(Scanner scan) throws Exception {
		return null;
	}

	public void userQuestions(Queue<String> queue) {

	}

	private String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
}
