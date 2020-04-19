package cs255tsp;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.util.*;

/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class TSPDriver {
	
	/**
	 * @param args
	 * @throws IOException
	 * Main Function call
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TSPHelper tspHelper = new TSPHelper();
		ReadCities readCities = new ReadCities();
		List<City> citiesList = readCities.insertCities(TSPHelper.citiesFilePath); //Reads the cities file from the predefined path.
		ReadDistanceMatrix readDistance = new ReadDistanceMatrix();
		double[][] distanceMatrix = readDistance.insertDistances(TSPHelper.distanceFilePath); //Reads the distance matrix from the predefined path.
		Scanner scanner = new Scanner(System.in);
		String approach = "Enter the approach to solve Traveling Salesman Problem:\n"+
							"1. Brute Force Approach\n"+
							"2. Greedy Approach\n"+
							"3. Dynamic Programming Approach\n";
		System.out.println(approach);
		int choice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Starting City for the travel");
		String startingCity = scanner.nextLine();
		scanner.close();
		
		switch (choice) {
		case 1:
			citiesList.remove(new City(startingCity));
			int cityID = tspHelper.getStartCityID(startingCity, citiesList);
			new TSPBruteForce(citiesList.size(),new City(startingCity,cityID,true),citiesList,distanceMatrix);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + 1);
		}
		
	}

}
