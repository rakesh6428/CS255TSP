package cs255tsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Angela Wang, Rakesh Gururaj
 * This class is used to Read cities from the file and create cities list.
 */
public class ReadCities {
	
	List<String> citiesList = new ArrayList<String>();
	
	/**
	 * @param citiesFilePath - The path of the file. Please specify full path.
	 * @return List of cities
	 */
	List<String> insertCities(String citiesFilePath) {
		try {
			File citiesFile = new File(citiesFilePath);
			Scanner fileScanner = new Scanner(citiesFile);
			while (fileScanner.hasNextLine()) {
				String[] city = fileScanner.nextLine().trim().split(" ");
				//citiesList.add(new City(city[0], Integer.parseInt(city[1]), false));
				citiesList.add(city[0]);
			}
			fileScanner.close();
			return citiesList;
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("The Path you have mentioned does not exist,Please enter valid file path!!!");
			return citiesList;
		}
	}

}
