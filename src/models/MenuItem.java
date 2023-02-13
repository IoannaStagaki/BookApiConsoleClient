package models;

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
		System.out.println("Parent");
	}

	public void userQuestions(Scanner scann) {
		System.out.println("Parent");
	}

	private String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

}
