package models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

import api.ApiCalls;

public class MenuOneOptionOne extends MenuItem {
	private HashMap<Integer, String> options;
	private ArrayList<String> extraOptions;
	private ArrayList<String> typeOfMedia;
	private ArrayList<String> filters;
	private ArrayList<String> printType;
	private ArrayList<String> projection;
	private ArrayList<String> sorting;
	private ArrayList<String> extraOptionChoiseMenu;

	public MenuOneOptionOne() {
		this.options = new HashMap<Integer, String>();
		this.options.put(0, "intitle");
		this.options.put(1, "inauthor");
		this.options.put(2, "inpublisher");
		this.options.put(3, "subject");
		this.options.put(4, "isbn");
		this.options.put(5, "lccn");
		this.options.put(6, "oclc");
		
		this.extraOptionChoiseMenu = new ArrayList<String>();
		this.extraOptionChoiseMenu.add("Ναι");
		this.extraOptionChoiseMenu.add("Όχι");
		

		this.extraOptions = new ArrayList<String>();
		this.extraOptions.add("Τίτλο");
		this.extraOptions.add("Συγγραφέα");
		this.extraOptions.add("Εκδότη");
		this.extraOptions.add("Περιεχόμενο");
		this.extraOptions.add("ISBN");
		this.extraOptions.add("Αριθμό Ελέγχου της Βιβλιοθήκης του Κογκρέσου");
		this.extraOptions.add("Αριθμό Κέντρου Ηλεκτρονικής Βιβλιοθήκης Υπολογιστών");

		this.typeOfMedia = new ArrayList<String>();
		this.typeOfMedia.add("epub");
		this.typeOfMedia.add("Δεν επιθυμώ");
		
		this.filters = new ArrayList<String>();
		this.filters.add("partial");
		this.filters.add("full");
		this.filters.add("free-ebooks");
		this.filters.add("paid-ebooks");
		this.filters.add("ebooks");
		this.filters.add("Δεν επιθυμώ");

		this.printType = new ArrayList<String>();
		this.printType.add("all");
		this.printType.add("books");
		this.printType.add("magazines");
		this.printType.add("Δεν επιθυμώ");

		this.projection = new ArrayList<String>();
		this.projection.add("full");
		this.projection.add("lite");
		this.projection.add("Δεν επιθυμώ");

		this.sorting = new ArrayList<String>();
		this.sorting.add("relevance");
		this.sorting.add("newest");
		this.sorting.add("Δεν επιθυμώ");

		this.setTitle("Αναζήτηση τόμων με βάση ειδικά κριτήρια");
	}


	@Override
	public String userQuestions(BufferedReader scan) throws Exception {

		System.out.println("Παρακαλώ εισάγετε τον τόμο που ψάχνετε: ");
		String searchTerm = scan.readLine();
		String extraOption = "";
		String extraSearchTerm = "";

		int extraOptionUserChoise = this.validateAndReturnInput(extraOptionChoiseMenu,
				"Θέλετε κάποιο επιπλέον κριτήριο αναζήτησης;", scan);

		boolean extraOptionNeeded = extraOptionUserChoise == 0;

		if (extraOptionNeeded) {
			int extraOptionMenuChoise = this.validateAndReturnInput(this.extraOptions,
					"Παρακαλώ επιλέξτε το επιπλέον κριτήριο:", scan);

			extraOption = this.options.get(extraOptionMenuChoise);
			System.out.println("Παρακαλώ εισάγετε την λέξη αναζήτησης βάση του παραπάνω κριτηρίου:");
			extraSearchTerm = scan.readLine();
		}

		String mediaType = "";
		String extrafilter = "";
		String typeOfPrint = "";
		String projectionType = "";
		String shortingType = "";
		boolean isLastIndex = false;

		int mediaTypeChoise = this.validateAndReturnInput(this.typeOfMedia,
				"Θέλετε να είναι κάποιο από τις παραπάνω μορφές;", scan);
		isLastIndex = mediaTypeChoise + 1 == this.typeOfMedia.size();
		if (!isLastIndex) {
			mediaType = this.typeOfMedia.get(mediaTypeChoise);
		}

		int filterUserChoise = this.validateAndReturnInput(this.filters, "Θέλετε κάποιο επιπλέον φίλτρο;", scan);
		isLastIndex = filterUserChoise + 1 == this.filters.size();
		if (!isLastIndex) {
			extrafilter = this.filters.get(filterUserChoise);
		}

		int typeOfPrintChoise = this.validateAndReturnInput(this.printType, "Τι είδος εκτύπωσης επιθυμείτε;", scan);
		isLastIndex = typeOfPrintChoise + 1 == this.printType.size();
		if (!isLastIndex) {
			typeOfPrint = this.printType.get(typeOfPrintChoise);
		}

		int projectionUserChoise = this.validateAndReturnInput(this.projection,
				"Τι είδους προβολή πεδίων επιθυμείτε;", scan);
		isLastIndex = projectionUserChoise + 1 == this.projection.size();
		if (!isLastIndex) {
			projectionType = this.projection.get(projectionUserChoise);
		}
		
		int sortingUserChoise = this.validateAndReturnInput(this.sorting, "Τι είδους ταξινόμηση επιθυμείτε;", scan);
		isLastIndex = sortingUserChoise + 1 == this.sorting.size();
		if (!isLastIndex) {
			shortingType = this.sorting.get(sortingUserChoise);
		}

		ApiCalls api = new ApiCalls();
		try {
			Volumes volumes = api.GetVolumes(searchTerm, extraOption, extraSearchTerm, mediaType, 
					typeOfPrint,extrafilter,projectionType, shortingType);
			if (volumes.getItems() == null || volumes.getItems().size() == 0) {
				return searchTerm;
			}
			for (int i = 0; i < volumes.getItems().size(); i++) {
				System.out.println("=============");
				System.out.println(volumes.getItems().get(i).toString());
				System.out.println();
			}

			return searchTerm;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

}
