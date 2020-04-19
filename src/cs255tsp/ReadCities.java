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
	
	List<City> citiesList = new ArrayList<City>();
	
	/**
	 * @param citiesFilePath - The path of the file. Please specify full path.
	 * @return List of cities
	 */
	List<City> insertCities(String citiesFilePath) {
		try {
			File citiesFile = new File(citiesFilePath);
			Scanner fileScanner = new Scanner(citiesFile);
			while (fileScanner.hasNextLine()) {
				String[] city = fileScanner.nextLine().trim().split(" ");   //Scan and store each line item of the file in a string.
				int cityID= Integer.parseInt(city[1]);
				citiesList.add(new City(city[0], cityID, false));
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
