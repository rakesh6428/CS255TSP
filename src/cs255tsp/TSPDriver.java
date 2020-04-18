package cs255tsp;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class TSPDriver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String citiesFilePath = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/Germany_Cities.txt";
		String distanceFilePath = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/DistanceMatrix.txt";

		ReadCities readCities = new ReadCities();
		List<String> citiesList = readCities.insertCities(citiesFilePath);
		ReadDistanceMatrix readDistance = new ReadDistanceMatrix();
		double[][] distanceMatrix = readDistance.insertDistances(distanceFilePath);
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
		City city = new City(startingCity);
		
		switch (choice) {
		case 1:
			citiesList.remove(startingCity);
			TSPBruteForce tspBruteForce = new TSPBruteForce(citiesList.size(),city,citiesList);
			TSPRoute tspRoute = new TSPRoute();
			long routePermutations = tspBruteForce.calculatePermutationRoutes(citiesList.size());
			//List<TSPRoute> tspRoutes = 
			tspBruteForce.findAllPathsofTSP(tspRoute, citiesList);
			//tspBruteForce.calculateBestRouteTSP(city, tspRoutes, distanceMatrix);
			System.out.println("The number of routes that a Salesman can travel from "+startingCity+" is: "+routePermutations);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + 1);
		}
		
	}

}
