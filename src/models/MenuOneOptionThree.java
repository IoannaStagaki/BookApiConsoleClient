package models;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Queue;

public class MenuOneOptionThree extends MenuItem {
	public MenuOneOptionThree() {
		this.setTitle("Ιστορικό αναζητήσεων");
	}

	@Override
	public void userQuestions(Queue<String> LastFiveSearches) {
		ArrayList<String> lastFive = new ArrayList<String>(LastFiveSearches);
		System.out.println();
		if (lastFive.size() == 0) {
			System.out.println("Δεν υπάρχουν πρόσφατες αναζητήσεις");
			return;
		}
		for(int i =0; i <lastFive.size();i++) {
			System.out.println(MessageFormat.format("\t{0}. {1}", i + 1, lastFive.get(i)));
		}
		System.out.println();
	}
}
