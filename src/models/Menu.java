package models;

import java.util.ArrayList;

public class Menu {

	private String Title;
	private ArrayList<MenuItem> MenuItems;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public ArrayList<MenuItem> getMenuItems() {
		return MenuItems;
	}

	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		MenuItems = menuItems;
	}

}
