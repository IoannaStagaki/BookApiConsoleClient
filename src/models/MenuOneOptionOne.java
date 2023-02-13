package models;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import api.ApiCalls;

public class MenuOneOptionOne extends MenuItem {
	private HashMap<String, String> options;
	private ArrayList<String> extraOptions;

	public MenuOneOptionOne() {
		this.options = new HashMap<String, String>();
		this.options.put("1", "intitle");
		this.options.put("2", "inauthor");
		this.options.put("3", "inpublisher");
		this.options.put("4", "subject");
		this.options.put("5", "isbn");
		this.options.put("6", "lccn");
		this.options.put("7", "oclc");

		this.extraOptions = new ArrayList<String>();
		this.extraOptions.add("Τίτλο");
		this.extraOptions.add("Συγγραφέα");
		this.extraOptions.add("Εκδότη");
		this.extraOptions.add("Περιεχόμενο");
		this.extraOptions.add("ISBN");
		this.extraOptions.add("Αριθμό Ελέγχου της Βιβλιοθήκης του Κογκρέσου");
		this.extraOptions.add("Αριθμό Κέντρου Ηλεκτρονικής Βιβλιοθήκης Υπολογιστών");

		this.setTitle("Αναζήτηση τόμων με βάση ειδικά κριτήρια");
	}

	@Override
	public void userQuestions(Scanner scan) {
		System.out.println("Παρακαλώ εισάγετε τον τόμο που ψάχνετε: ");
		String searchTerm = scan.next();
		String extraOption = "";
		String extraSearchTerm = "";
		System.out.println("Θέλετε κάποιο επιπλέον κριτήριο αναζήτησης ?");
		System.out.println("1. Ναι");
		System.out.println("2. Οχι");
		String extraOptionChoise = scan.next();
		boolean extraOptionNeeded = extraOptionChoise.equals("1");
		if (extraOptionNeeded) {
			System.out.println("\tΠαρακαλώ επιλέξτε το επιπλέον κριτήριο: \n");
			for (int i = 0; i < this.extraOptions.size(); i++) {
				System.out.println(MessageFormat.format("\t{0}. {1}", i + 1, this.extraOptions.get(i)));
			}
			String extraOptionParameterChoise = scan.next();
			extraOption = this.options.get(extraOptionParameterChoise);
			System.out.println("Παρακαλώ εισάγετε την λέξη αναζήτησης βάση του παραπάνω κριτηρίου:");
			extraSearchTerm = scan.next();
		}
		ApiCalls api = new ApiCalls();
		try {
			Volumes volumes = api.GetVolumes(searchTerm, extraOption, extraSearchTerm);
			volumes.getItems().stream().forEach(item -> {
				System.out.println("=============");
				System.out.println(item.toString());
				System.out.println();
			});
		} catch (Exception e) {


		}

	}
}
